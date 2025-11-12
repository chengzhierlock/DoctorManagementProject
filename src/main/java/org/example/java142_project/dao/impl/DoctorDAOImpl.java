package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.DoctorDAO;
import org.example.java142_project.entity.Doctor;

import java.util.List;

public class DoctorDAOImpl extends MyJDBCTemplate implements DoctorDAO {
    @Override
    public List<Doctor> selectAll() throws DAOException {
        return List.of();
    }

    @Override
    public Doctor selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean insert(Doctor doctor) throws DAOException {
        String SQL = "insert into tab_doctor (did,name,gender,birthday,joid,deid,edid,iconimg) values (?,?,?,?,?,?,?,?)";
        try {
            return this.execUpd(SQL,doctor.getDid(),doctor.getName(),doctor.getGender(),doctor.getBirthday(),doctor.getJoid(),doctor.getDeid(),doctor.getEdid(),doctor.getIconimg());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean update(Doctor doctor) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        return false;
    }
}
