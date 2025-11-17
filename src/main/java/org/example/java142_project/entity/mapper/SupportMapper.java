package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Support;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupportMapper implements RowMapper<Support> {

    @Override
    public Support mapRow(ResultSet rst) {
        Support support = new Support();
        try {
            support.setSupportid(rst.getInt("suid"));
            support.setSupname(rst.getString("supname"));
            support.setTel(rst.getString("tel"));
            support.setEmail(rst.getString("email"));
            support.setAddress(rst.getString("address"));
            support.setSupdesc(rst.getString("supdesc"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return support;
    }
}
