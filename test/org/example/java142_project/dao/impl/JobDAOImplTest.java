package org.example.java142_project.dao.impl;

import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.dao.JobDAO;
import org.example.java142_project.entity.Job;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobDAOImplTest {
    JobDAO jobDAO = new JobDAOImpl();
    @Test
    void del() throws DAOException {
        boolean del = jobDAO.del(5);
        assertTrue(del);
    }

    @Test
    void insert() throws DAOException {
        Job job = new Job();
        job.setJobname("test1");
        job.setJobdescp("test1 descp");
        boolean insert = jobDAO.insert(job);
        assertTrue(insert);
    }

    @Test
    void selectAll() throws DAOException {
        List<Job> jobs = jobDAO.selectAll();
        jobs.forEach(System.out::println);
    }
}