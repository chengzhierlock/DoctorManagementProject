package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements RowMapper<Login> {

    @Override
    public Login mapRow(ResultSet rst) {
        Login login = new Login();
        try {
            login.setId(rst.getInt("id"));
            login.setLoginname(rst.getString("loginname"));
            login.setIslogin(rst.getInt("islogin"));
            login.setPass(rst.getString("pass"));
            login.setRoleid(rst.getInt("roleid"));
            return login;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
