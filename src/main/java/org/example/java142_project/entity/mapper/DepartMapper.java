package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartMapper implements RowMapper<Dept> {
    @Override
    public Dept mapRow(ResultSet rst) {
        Dept dept = new Dept();
        try {
            dept.setDeptid(rst.getInt("departid"));
            dept.setDeptname(rst.getString("departname"));
            dept.setDeptdescp(rst.getString("departdescp"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dept;
    }
}
