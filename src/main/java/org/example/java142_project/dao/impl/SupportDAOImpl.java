package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.SupportDAO;
import org.example.java142_project.entity.Support;
import org.example.java142_project.entity.mapper.SupportMapper;

import java.util.List;

public class SupportDAOImpl extends MyJDBCTemplate implements SupportDAO {
    @Override
    public List<Support> selectAll() throws DAOException {
        String sql = "select suid,supname,tel,email,address,supdesc from tab_support";
        try {
            return this.queryAll(sql,new SupportMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Support selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean insert(Support support) throws DAOException {
        String sql = "insert into tab_support(suid,supname,tel,email,address,supdesc) values(null,?,?,?,?,?)";
        try {
            return this.execUpd(sql,support.getSupname(),support.getTel(),support.getEmail(),support.getAddress(),support.getSupdesc());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean update(Support support) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql = "delete from tab_support where suid=?";
        try {
            return this.execUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
