package org.example.java142_project.service.impl;

import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.entity.Doctor;
import org.example.java142_project.entity.Login;
import org.example.java142_project.service.DoctorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceImplTest {
    DoctorService doctorService = new DoctorServiceImpl();
    @Test
    void addDoctor() throws ServiceException {
        Login login = new Login();
        login.setLoginname("doctor1");
        Doctor doctor = new Doctor();
        doctor.setGender("男");
        doctor.setBirthday("2020-02-02");
        doctor.setJoid(1);
        doctor.setDeid(1);
        doctor.setEdid(1);
        doctor.setIconimg("/imgs.icon1.jpg");
        doctor.setName("李晓明");
        boolean b = doctorService.addDoctor(login,doctor);
        assertTrue(b);
    }
}