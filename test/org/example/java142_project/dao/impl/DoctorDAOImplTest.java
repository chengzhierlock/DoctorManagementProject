package org.example.java142_project.dao.impl;

import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.dao.DoctorDAO;
import org.example.java142_project.vo.DoctorVO;
import org.junit.jupiter.api.Test;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DoctorDAOImplTest {
    DoctorDAO doctorDAO = new DoctorDAOImpl();

    @Test
    void listByPage() throws DAOException {
        Map<String, String> map = new HashMap<>();
        map.put("offset","0");
        map.put("size","4");
        List<DoctorVO> doctorVOS = doctorDAO.ListByPage(map);
        doctorVOS.forEach(System.out::println);
    }

    @Test
    void countPage() throws DAOException {
        Map<String, String> map = new HashMap<>();
        int i = doctorDAO.countPage(map);
        System.out.println(i);
    }
}