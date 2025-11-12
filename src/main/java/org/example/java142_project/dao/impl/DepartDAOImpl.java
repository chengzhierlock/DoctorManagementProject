package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.DeptDAO;
import org.example.java142_project.entity.Dept;
import org.example.java142_project.entity.mapper.DepartMapper;

import java.util.List;

public class DepartDAOImpl extends MyJDBCTemplate implements DeptDAO {
    @Override
    public List<Dept> selectAll() throws DAOException {
        String SQL = "select departid,departname,departdescp from tab_depatinfo";
        try {
            return this.queryAll(SQL,new DepartMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Dept selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean insert(Dept dept) throws DAOException {
        String SQL = "insert into tab_depatinfo (departid,departname,departdescp) values (null,?,?)";
        try {
            return this.execUpd(SQL,dept.getDeptname(),dept.getDeptdescp());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean update(Dept dept) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        String SQL = "delete from tab_depatinfo where departid=?";
        try {
            return this.execUpd(SQL,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
