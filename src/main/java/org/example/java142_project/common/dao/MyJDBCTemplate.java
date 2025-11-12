package org.example.java142_project.common.dao;

import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.common.util.JDBCUtil;
import org.example.java142_project.dao.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

//模版设计
public abstract class MyJDBCTemplate {
//    增删改
    public boolean execUpd(final String SQL,Object ...params) throws DataException {
//        连接
        Connection conn = JDBCUtil.getJdbcUtil().getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            if (params != null && params.length > 0) {
                extraced(preparedStatement, params);
            }
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("增删出错");
        }
    }

//    设置sql语句
    public void extraced(PreparedStatement preparedStatement, Object ...params) throws SQLException {
        for(int i=0;i<params.length;i++) {
//                设置参数
            preparedStatement.setObject(i+1,params[i]);
        }
    }
//    显示所有记录
    public <T> List<T> queryAll(final String SQL, RowMapper<T> rowMapper,Object ...params) throws DataException {
        List<T> list = new LinkedList<T>();
        Connection conn = JDBCUtil.getJdbcUtil().getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            if (params != null && params.length > 0) {
                extraced(preparedStatement, params);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T t = rowMapper.mapRow(resultSet);
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("查询出错");
        }
        return list;
    }

//    添加医生记录 返回id
    public int insertRecord(final String SQL,Object ...params) throws DataException {
        Connection conn = JDBCUtil.getJdbcUtil().getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);
            extraced(preparedStatement,params);
            int row = preparedStatement.executeUpdate();
            if (row <1) throw new DataException("添加记录返回主键出错");
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataException("添加记录返回主键出错");
        }
        return 0;
    }
}
