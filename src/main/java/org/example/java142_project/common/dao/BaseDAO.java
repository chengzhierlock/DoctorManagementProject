package org.example.java142_project.common.dao;

import org.example.java142_project.common.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface BaseDAO<T> {
//    显示所有记录
    List<T> selectAll () throws DAOException;

//    显示一个
    T selectById(int id)  throws DAOException;

//    添加记录
    boolean insert(T t) throws DAOException;
//    更新
    boolean update(T t) throws DAOException;
//    删除
    boolean del(int id) throws DAOException;
//    默认方法
    default int count(Map<String,String> map) throws DAOException {
        return 0;
    }
//    分页查询
    default List<T> selectByCond(Map<String,String> map) throws DAOException {
        return null;
    }
}
