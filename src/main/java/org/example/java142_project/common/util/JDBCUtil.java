package org.example.java142_project.common.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static BasicDataSource dataSource;
//    二级缓存
    private ThreadLocal<Connection> local = new ThreadLocal<>();
    private static JDBCUtil jdbcutil = new JDBCUtil();
    private JDBCUtil() {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JDBCUtil getJdbcUtil() {
        return jdbcutil;
    }
    public Connection getConn() {
//        缓存获取
        Connection con = local.get();
        if(con == null) {
            try {
//                获取连接
                con=dataSource.getConnection();
//                存入缓存
                local.set(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    public void close() {
        Connection con = local.get();
        if(con != null) {
            try {
                con.close();
                local.remove();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
