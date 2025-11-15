package org.example.java142_project.service.impl;

import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.dao.AdminDAO;
import org.example.java142_project.dao.DoctorDAO;
import org.example.java142_project.dao.LoginDAO;
import org.example.java142_project.dao.impl.AdminDAOImpl;
import org.example.java142_project.dao.impl.DoctorDAOImpl;
import org.example.java142_project.dao.impl.LoginDAOImpl;
import org.example.java142_project.entity.Login;
import org.example.java142_project.service.LoginService;
import org.example.java142_project.vo.AdminVO;
import org.example.java142_project.vo.DoctorVO;

public class LoginServiceImpl implements LoginService {
    LoginDAO loginDAO = new LoginDAOImpl();
    private DoctorDAO doctorDAO = new DoctorDAOImpl();
    private AdminDAO adminDAO = new AdminDAOImpl();
    @Override
    public Login isLogin(String name, String pass) throws ServiceException {
        try {
            return loginDAO.login(name,pass);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public AdminVO getAdminLoginInfo(int id) throws ServiceException {
        try {
            return adminDAO.getLoginInfo(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public DoctorVO getDocLoginInfo(int id) throws ServiceException {
        try {
            return doctorDAO.getDocLoginInfo(String.valueOf(id));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
