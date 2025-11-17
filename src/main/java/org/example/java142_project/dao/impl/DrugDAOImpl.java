package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.DrugDAO;
import org.example.java142_project.entity.Drug;
import org.example.java142_project.entity.mapper.DrugMapper;

import java.util.List;

public class DrugDAOImpl extends MyJDBCTemplate implements DrugDAO {
    @Override
    public List<Drug> selectAll() throws DAOException {
        String sql = "select cid,cname,cdescp,lastdate from tab_drugtype";
        try {
            return this.queryAll(sql,new DrugMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Drug selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean insert(Drug drug) throws DAOException {
        String sql = "insert into tab_drugtype (cid,cname,cdescp,lastdate) values (null,?,?,?);";
        try {
            return this.execUpd(sql,drug.getCname(),drug.getCdescp(),drug.getLastdate());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean update(Drug drug) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql = "delete from tab_drugtype where cid = ?";
        try {
            return this.execUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

}
