package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.EducationDAO;
import org.example.java142_project.entity.Education;
import org.example.java142_project.entity.mapper.EducationMapper;

import java.util.List;

public class EducationDAOImpl extends MyJDBCTemplate implements EducationDAO {
    @Override
    public List<Education> selectAll() throws DAOException {
        String SQL = "select eid,ename,edescp from tab_educationinfo";
        try {
            return this.queryAll(SQL, new EducationMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Education selectById(int id) throws DAOException {
        String SQL = "select eid,ename,edescp from tab_educationinfo where eid=?";
        try {
            return this.queryOne(SQL, new EducationMapper(), id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean insert(Education education) throws DAOException {
        String SQL = "insert into tab_educationinfo(eid,ename,edescp) values(null,?,?)";
        try {
            return this.execUpd(SQL,education.getEname(), education.getEdescp());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean update(Education education) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int eid) throws DAOException {
        String SQL = "delete from tab_educationinfo where eid=?";
        try {
            return this.execUpd(SQL,eid);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
