package org.example.java142_project.dao;

import org.example.java142_project.common.dao.BaseDAO;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.entity.Login;

public interface LoginDAO extends BaseDAO<Login> {
    int addRec(Login login) throws DAOException;
    Login findByName (String loginName) throws  DAOException;
    Login login(String name,String pass) throws DAOException;
}
