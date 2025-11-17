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
    @Override
    public boolean updatePassword(String loginname, String oldPassword, String newPassword) throws ServiceException {
        try {
            // 1. 参数验证
            if (loginname == null || loginname.trim().isEmpty()) {
                throw new ServiceException("登录名不能为空");
            }
            if (oldPassword == null || oldPassword.trim().isEmpty()) {
                throw new ServiceException("原密码不能为空");
            }
            if (newPassword == null || newPassword.trim().isEmpty()) {
                throw new ServiceException("新密码不能为空");
            }

            // 2. 业务规则验证：新密码不能与原密码相同
            if (oldPassword.equals(newPassword)) {
                throw new ServiceException("新密码不能与原密码相同");
            }

            // 3. 调用DAO层验证原密码
            boolean isOldPasswordCorrect = loginDAO.verifyPassword(loginname, oldPassword);
            if (!isOldPasswordCorrect) {
                throw new ServiceException("原密码不正确");
            }

            // 4. 调用DAO层更新密码
            boolean updateSuccess = loginDAO.updatePassword(loginname, newPassword);
            if (!updateSuccess) {
                throw new ServiceException("密码更新失败，请稍后重试");
            }

            return true;

        } catch (DAOException e) {
            throw new ServiceException("数据库操作失败: " + e.getMessage());
        }
    }
}
