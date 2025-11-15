package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet rst) {
        Admin admin = new Admin();
        try {
            admin.setAid(rst.getInt("aid"));
            admin.setAname(rst.getString("aname"));
            admin.setGender(rst.getString("gender"));
            admin.setTel(rst.getString("tel"));
            admin.setEmail(rst.getString("email"));
            admin.setWebchat(rst.getString("webchat"));
            admin.setQq(rst.getString("qq"));
            admin.setIconimg(rst.getString("iconimg"));
            return admin;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
