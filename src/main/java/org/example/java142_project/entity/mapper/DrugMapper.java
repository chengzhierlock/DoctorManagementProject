package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Drug;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugMapper implements RowMapper<Drug> {
    @Override
    public Drug mapRow(ResultSet rst) {
        Drug drug = new Drug();
        try {
           drug.setCid(rst.getInt("cid"));
           drug.setCname(rst.getString("cname"));
           drug.setCdescp(rst.getString("cdescp"));
           drug.setLastdate(rst.getString("lastdate"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return drug;
    }
}
