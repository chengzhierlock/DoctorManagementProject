package org.example.java142_project.dao.impl;

import org.example.java142_project.common.dao.MyJDBCTemplate;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.DataException;
import org.example.java142_project.dao.DoctorDAO;
import org.example.java142_project.entity.Doctor;
import org.example.java142_project.vo.DoctorVO;
import org.example.java142_project.vo.mapper.DoctorVOMapper;

import java.util.List;
import java.util.Map;

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
        String SQL = "update tab_doctor set name = ?,gender = ?,birthday = ?,joid = ?,deid = ?,edid = ?,iconimg = ? where did = ?";
        try {
            return this.execUpd(SQL,doctor.getName(),doctor.getGender(),doctor.getBirthday(),doctor.getJoid(),doctor.getDeid(),doctor.getEdid(),doctor.getIconimg(),doctor.getDid());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        String SQL = "delete from tab_doctor where did = ?";
        try {
            return this.execUpd(SQL,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<DoctorVO> ListByPage(Map<String, String> map) throws DAOException {
        String baseSql = """
                select
                d.did,d.name,d.gender,d.birthday,l.loginname,d.joid,j.jobname,l.pass,l.roleid,l.islogin,d.deid,de.departname
                ,d.edid,e.ename,d.iconimg
                from
                tab_doctor d
                left join
                tab_login l
                on d.did = l.id
                left join tab_jobinfo j
                on d.joid = j.jobid
                left join tab_depatinfo de
                on d.deid = de.departid
                left join tab_educationinfo e
                on d.edid = e.eid
                where 1 = 1
                """;
        try {
            return this.queryRecord(baseSql, new DoctorVOMapper(), map);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public int countPage(Map<String, String> map) throws DAOException {
        String sql = """
                select
                count(d.did) num
                from
                tab_doctor d
                left join
                tab_login l
                on d.did = l.id
                left join tab_jobinfo j
                on d.joid = j.jobid
                left join tab_depatinfo de
                on d.deid = de.departid
                left join tab_educationinfo e
                on d.edid = e.eid
                where 1 = 1
                """;
        try {
            return this.countRecord(sql, map);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
