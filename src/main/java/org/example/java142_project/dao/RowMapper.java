package org.example.java142_project.dao;

import java.sql.ResultSet;

//将关系型数据库中表映射为类，表记录映射为对象
//orm:Object relation mapping            mybatis
public interface RowMapper<T> {
    T mapRow(ResultSet rst);
}
