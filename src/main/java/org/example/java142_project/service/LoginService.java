package org.example.java142_project.service;

import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.entity.Login;
import org.example.java142_project.vo.AdminVO;
import org.example.java142_project.vo.DoctorVO;

public interface LoginService {
    Login isLogin(String name, String pass) throws ServiceException;
    AdminVO getAdminLoginInfo(int id) throws ServiceException;
    DoctorVO getDocLoginInfo(int id) throws ServiceException;
}
