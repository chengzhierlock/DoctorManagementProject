package org.example.java142_project.vo.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Doctor;
import org.example.java142_project.vo.DoctorVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorVOMapper implements RowMapper<DoctorVO> {
    @Override
    public DoctorVO mapRow(ResultSet rst) {
        DoctorVO doctorVO = new DoctorVO();
        try {
            doctorVO.setDid(rst.getInt("did"));
            doctorVO.setLoginName(rst.getString("loginname"));
            doctorVO.setName(rst.getString("name"));
            doctorVO.setPass(rst.getString("pass"));
            doctorVO.setGender(rst.getString("gender"));
            doctorVO.setBirthday(rst.getString("birthday"));
            doctorVO.setRoleid(rst.getInt("roleid"));
            doctorVO.setIslogin(rst.getInt("islogin"));
            doctorVO.setJoid(rst.getInt("joid"));
            doctorVO.setDeid(rst.getInt("deid"));
            doctorVO.setEdid(rst.getInt("edid"));
            doctorVO.setIconimg(rst.getString("iconimg"));
            doctorVO.setJobname(rst.getString("jobname"));
            doctorVO.setDepartname(rst.getString("departname"));
            doctorVO.setEdname(rst.getString("ename"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctorVO;
    }
}
