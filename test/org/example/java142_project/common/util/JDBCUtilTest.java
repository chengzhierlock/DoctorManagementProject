package org.example.java142_project.common.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
class JDBCUtilTest {

    @Test
    void getJdbcUtil() {
    }

    @Test
    void getConn() {
        Connection con = JDBCUtil.getJdbcUtil().getConn();
        System.out.println(con);
    }

    @Test
    void close() {
    }
}