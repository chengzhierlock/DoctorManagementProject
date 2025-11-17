package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.LoginDAO;
import org.example.java142_project.entity.Login;
import org.example.java142_project.entity.mapper.LoginMapper;

import java.util.List;

public class LoginDAOImpl extends MyJDBCTemplate implements LoginDAO {
    @Override
    public List<Login> selectAll() throws DAOException {
        return List.of();
    }

    @Override
    public Login selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean insert(Login login) throws DAOException {
        return false;
    }

    @Override
    public boolean update(Login login) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        String SQL = "delete from tab_login where id=?";
        try {
            return this.execUpd(SQL,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public int addRec(Login login) throws DAOException {
        String SQL = "insert into tab_login(id,loginname,pass,roleid,islogin) values(null,?,'8888',2,0)";
        try {
            return this.insertRecord(SQL,login.getLoginname());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Login findByName(String loginName) throws DAOException {
        String SQL = "select * from tab_login where loginname = ?";
        try {
            return this.queryOne(SQL,new LoginMapper(),loginName);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Login login(String name, String pass) throws DAOException {
        String SQL = "select * from tab_login where loginname = ? and pass = ?";
        try {
            return this.queryOne(SQL,new LoginMapper(),name,pass);
        } catch (DataException e) {
            throw new DAOException("查询错误");
        }
    }

    @Override
    public boolean verifyPassword(String loginname, String password) throws DAOException {
        String SQL = "SELECT * FROM tab_login WHERE loginname = ? AND pass = ?";
        try {
            Login login = this.queryOne(SQL, new LoginMapper(), loginname, password);
            return login != null;
        } catch (DataException e) {
            throw new DAOException("验证密码时发生错误: " + e.getMessage());
        }
    }

    @Override
    public boolean updatePassword(String loginname, String newPassword) throws DAOException {
        String SQL = "UPDATE tab_login SET pass = ? WHERE loginname = ?";
        try {
            return this.execUpd(SQL, newPassword, loginname);
        } catch (DataException e) {
            throw new DAOException("更新密码时发生错误: " + e.getMessage());
        }
    }


}
