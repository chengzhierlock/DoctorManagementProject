package org.example.java142_project.dao;

import org.example.java142_project.common.dao.BaseDAO;
import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.entity.Doctor;
import org.example.java142_project.vo.DoctorVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DoctorDAO extends BaseDAO<Doctor> {
    List<DoctorVO> ListByPage(Map<String,String> map) throws DAOException;
    int  countPage(Map<String,String> map) throws DAOException;
    DoctorVO getDocLoginInfo(String loginname) throws DAOException;
}
