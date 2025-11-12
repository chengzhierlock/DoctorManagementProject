package org.example.java142_project.service.impl;

import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.dao.DeptDAO;
import org.example.java142_project.dao.EducationDAO;
import org.example.java142_project.dao.JobDAO;
import org.example.java142_project.dao.impl.DepartDAOImpl;
import org.example.java142_project.dao.impl.EducationDAOImpl;
import org.example.java142_project.dao.impl.JobDAOImpl;
import org.example.java142_project.entity.Dept;
import org.example.java142_project.entity.Education;
import org.example.java142_project.entity.Job;
import org.example.java142_project.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private JobDAO jobDAO = new JobDAOImpl();
    private EducationDAO eduDAO = new EducationDAOImpl();
    private DeptDAO depDAO = new DepartDAOImpl();
    @Override
    public List<Job> listJobAll() throws ServiceException {
        try {
            return jobDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addJob(Job job) throws ServiceException {
        try {
            return jobDAO.insert(job);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delJob(int id) throws ServiceException {
        try {
            return jobDAO.del(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addEducation(Education ed) throws ServiceException {
        try {
            return eduDAO.insert(ed);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delEducation(int eid) throws ServiceException {
        try {
            return eduDAO.del(eid);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Education> listEduAll() throws ServiceException {
        try {
            return eduDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Dept> listDepAll() throws ServiceException {
        try {
            return depDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addDept(Dept dept) throws ServiceException {
        try {
            return depDAO.insert(dept);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delDept(int id) throws ServiceException {
        try {
            return depDAO.del(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
