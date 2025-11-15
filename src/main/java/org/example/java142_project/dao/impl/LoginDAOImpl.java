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
        return false;
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
}
