package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.AdminDAO;
import org.example.java142_project.entity.Admin;
import org.example.java142_project.vo.AdminVO;
import org.example.java142_project.vo.mapper.AdminVOMapper;

import java.util.List;

public class AdminDAOImpl extends MyJDBCTemplate implements AdminDAO {
    @Override
    public AdminVO getLoginInfo(int id) throws DAOException {
        String sql = """
                SELECT a.*,l.loginname,l.pass,l.roleid,l.islogin
                FROM tab_admin a
                LEFT JOIN tab_login l ON a.aid = l.id
                where aid = ?
                """;
        try {
            return this.queryOne(sql,new AdminVOMapper(),id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<Admin> selectAll() throws DAOException {
        return List.of();
    }

    @Override
    public Admin selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean insert(Admin admin) throws DAOException {
        return false;
    }

    @Override
    public boolean update(Admin admin) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        return false;
    }
}
