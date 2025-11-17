package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.DrugsDAO;
import org.example.java142_project.entity.Drugs;
import org.example.java142_project.entity.mapper.DrugsMapper;

import java.util.List;

public class DrugsDAOImpl extends MyJDBCTemplate implements DrugsDAO {
    @Override
    public List<Drugs> selectAll() throws DAOException {
        String sql = "select * from tab_drug";
        try {
            return this.queryAll(sql,new DrugsMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Drugs selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean insert(Drugs drugs) throws DAOException {
        String sql = "insert into tab_drug values(null,?,?,?,?,?,?,?,?,?,?)";
        try {
            return this.execUpd(sql,drugs.getDrugname(),drugs.getDrugtype(),drugs.getDrugunit(),drugs.getSupport(),drugs.getProductdate(),drugs.getEffectdate(),drugs.getStock(),drugs.getPurchaseprice(),drugs.getPrice(),drugs.getDescp());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public boolean update(Drugs drugs) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql = "delete from tab_drug where drugid = ?";
        try {
            return this.execUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
