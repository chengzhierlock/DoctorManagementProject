package org.example.java142_project.service.impl;

import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.dao.*;
import org.example.java142_project.dao.impl.*;
import org.example.java142_project.entity.*;
import org.example.java142_project.service.DoctorService;
import org.example.java142_project.vo.DoctorVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorServiceImpl implements DoctorService {
    private JobDAO jobDAO = new JobDAOImpl();
    private EducationDAO eduDAO = new EducationDAOImpl();
    private DeptDAO depDAO = new DepartDAOImpl();
    private LoginDAO loginDAO = new LoginDAOImpl();
    private DoctorDAO doctorDAO = new DoctorDAOImpl();
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

    @Override
    public boolean addDoctor(Login login, Doctor doctor) throws ServiceException {
        try {
            int id = loginDAO.addRec(login);
            doctor.setDid(id);
            return doctorDAO.insert(doctor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<DoctorVO> listDoctorAll(Map<String, String> map) throws ServiceException {
        int page = 0;//当前页
        int size = 0;//每页记录
        if (map.containsKey("pages")) {
            page = Integer.parseInt(map.get("pages"));
            map.remove("pages");
        }
        if (map.containsKey("size")) {
            size = Integer.parseInt(map.get("size"));
        }
//        设置每页起始记录
        map.put("offset",String.valueOf((page-1)*size));
        try {
            return doctorDAO.ListByPage(map);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public int CountInfo(Map<String, String> map) throws ServiceException {
        try {
            return doctorDAO.countPage(map);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
