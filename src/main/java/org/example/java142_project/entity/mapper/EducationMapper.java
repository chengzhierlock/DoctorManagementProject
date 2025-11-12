package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Education;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationMapper implements RowMapper<Education> {
    @Override
    public Education mapRow(ResultSet rst) {
        Education edu = new Education();
        try {
            edu.setEid(rst.getInt("eid"));
            edu.setEname(rst.getString("ename"));
            edu.setEdescp(rst.getString("edescp"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return edu;
    }
}
