package org.example.java142_project.entity.mapper;

import org.example.java142_project.dao.RowMapper;
import org.example.java142_project.entity.Drugs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugsMapper implements RowMapper<Drugs> {

    @Override
    public Drugs mapRow(ResultSet rst) {
        Drugs drugs = new Drugs();
        try {
            drugs.setDrugid(rst.getInt("drugid"));
            drugs.setDrugname(rst.getString("drugname"));
            drugs.setDrugtype(rst.getInt("drugtype"));
            drugs.setDrugunit(rst.getString("drugunit"));
            drugs.setSupport(rst.getInt("support"));
            drugs.setProductdate(rst.getString("productdate"));
            drugs.setEffectdate(rst.getString("effectdate"));
            drugs.setStock(rst.getInt("stock"));
            drugs.setPurchaseprice(rst.getFloat("purchaseprice"));
            drugs.setPrice(rst.getFloat("price"));
            drugs.setDescp(rst.getString("descp"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return drugs;
    }
}
