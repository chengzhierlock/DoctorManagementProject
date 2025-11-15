package org.example.java142_project.service;

import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.entity.*;
import org.example.java142_project.vo.DoctorVO;

import java.util.List;
import java.util.Map;

public interface DoctorService {
//    职称
    List<Job> listJobAll() throws ServiceException;
    boolean addJob(Job job) throws ServiceException;
    boolean delJob(int id) throws ServiceException;
    Job finaOneJob (int id) throws ServiceException;
//    学历
    boolean addEducation(Education ed) throws ServiceException;
    boolean delEducation(int eid) throws ServiceException;
    List<Education> listEduAll() throws ServiceException;
    Education findOneEdu(int id) throws ServiceException;
//    科室
    List<Dept> listDepAll() throws ServiceException;
    boolean addDept(Dept dept) throws ServiceException;
    boolean delDept(int id) throws ServiceException;
    Dept findOneDept(int id) throws ServiceException;

//    医生模块
//    添加
    boolean addDoctor(Login login, Doctor doctor) throws ServiceException;
//    查询所有
    List<DoctorVO> listDoctorAll(Map<String,String> map) throws ServiceException;
//    查询总数
    int CountInfo(Map<String,String> map) throws ServiceException;
//    更新医生
    boolean editDoctor (Doctor doctor) throws ServiceException;
//    删除
    boolean delDoctor(int id) throws ServiceException;
}
