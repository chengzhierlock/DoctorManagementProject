package org.example.java142_project.dao;

import org.example.java142_project.common.dao.BaseDAO;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.entity.Admin;
import org.example.java142_project.vo.AdminVO;

public interface AdminDAO extends BaseDAO<Admin> {
    AdminVO getLoginInfo(int id) throws DAOException;

}
