package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Job;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobMapper implements RowMapper<Job> {
    @Override
    public Job mapRow(ResultSet rst) {
        Job job = new Job();
        try {
            job.setJobid(rst.getInt("jobid"));
            job.setJobname(rst.getString("jobname"));
            job.setJobdescp(rst.getString("jobdescp"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return job;
    }
}
