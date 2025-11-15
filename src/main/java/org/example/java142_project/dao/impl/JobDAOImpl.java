package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.JobDAO;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.entity.Job;
import org.example.java142_project.entity.mapper.JobMapper;

import java.util.List;

public class JobDAOImpl extends MyJDBCTemplate implements JobDAO {
    @Override
    public boolean del(int id) throws DAOException {
        String SQL = "delete from tab_jobinfo where jobid=?";
        try {
            return this.execUpd(SQL,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean update(Job job) throws DAOException {
        return false;
    }

    @Override
    public boolean insert(Job job) throws DAOException {
        String SQL = "insert into tab_jobinfo (jobid,jobname,jobdescp) values (null,?,?)";
        Object obj[] = {job.getJobname(),job.getJobdescp()};
        try {
            return this.execUpd(SQL,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Job selectById(int id) throws DAOException {
        String SQL = "select jobid,jobname,jobdescp from tab_jobinfo where jobid=?";
        try {
            return this.queryOne(SQL,new JobMapper(),id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<Job> selectAll() throws DAOException {
        String SQL = "select jobid,jobname,jobdescp from tab_jobinfo";
        try {
            return this.queryAll(SQL,new JobMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
