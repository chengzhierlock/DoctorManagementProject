package org.example.java142_project.vo.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.vo.DrugVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugVOMapper implements RowMapper<DrugVO> {

    @Override
    public DrugVO mapRow(ResultSet rst) {
        DrugVO drugVO = new DrugVO();
        try {
            drugVO.setDrugid(rst.getInt("drugid"));
            drugVO.setDrugname(rst.getString("drugname"));
            drugVO.setDrugtype(rst.getInt("drugtype"));
            drugVO.setDrugunit(rst.getString("drugunit"));
            drugVO.setSupport(rst.getInt("support"));
            drugVO.setProductdate(rst.getString("productdate"));
            drugVO.setEffectdate(rst.getString("effectdate"));
            drugVO.setStock(rst.getInt("stock"));
            drugVO.setPurchaseprice(rst.getFloat("purchaseprice"));
            drugVO.setPrice(rst.getFloat("price"));
            drugVO.setDescp(rst.getString("descp"));
            drugVO.setCid(rst.getInt("cid"));
            drugVO.setCname(rst.getString("cname"));
            drugVO.setCdescp(rst.getString("cdescp"));
            drugVO.setLastdate(rst.getString("lastdate"));
            drugVO.setSuid(rst.getInt("suid"));
            drugVO.setSupname(rst.getString("supname"));
            drugVO.setTel(rst.getString("tel"));
            drugVO.setEmail(rst.getString("email"));
            drugVO.setAddress(rst.getString("address"));
            drugVO.setSupdesc(rst.getString("supdesc"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return drugVO;
    }
}
