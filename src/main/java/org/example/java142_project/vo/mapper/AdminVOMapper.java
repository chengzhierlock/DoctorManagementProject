package org.example.java142_project.vo.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.vo.AdminVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminVOMapper implements RowMapper<AdminVO> {
    @Override
    public AdminVO mapRow(ResultSet rst) {
        AdminVO adminVO = new AdminVO();
        try {
            adminVO.setAid(rst.getInt("aid"));
            adminVO.setAname(rst.getString("aname"));
            adminVO.setGender(rst.getString("gender"));
            adminVO.setTel(rst.getString("tel"));
            adminVO.setEmail(rst.getString("email"));
            adminVO.setWebchat(rst.getString("webchat"));
            adminVO.setQq(rst.getString("qq"));
            adminVO.setIconimg(rst.getString("iconimg"));
            adminVO.setLoginname(rst.getString("loginname"));
            adminVO.setPass(rst.getString("pass"));
            adminVO.setRoleid(rst.getInt("roleid"));
            adminVO.setIslogin(rst.getInt("islogin"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adminVO;
    }
}
