package org.example.java142_project.service;

import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.entity.Dept;
import org.example.java142_project.entity.Education;
import org.example.java142_project.entity.Job;

import java.util.List;

public interface DoctorService {
//    职称
    List<Job> listJobAll() throws ServiceException;
    boolean addJob(Job job) throws ServiceException;
    boolean delJob(int id) throws ServiceException;
    boolean addEducation(Education ed) throws ServiceException;
    boolean delEducation(int eid) throws ServiceException;
    List<Education> listEduAll() throws ServiceException;
    List<Dept> listDepAll() throws ServiceException;
    boolean addDept(Dept dept) throws ServiceException;
    boolean delDept(int id) throws ServiceException;
}
