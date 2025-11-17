package org.example.java142_project.service;

import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.entity.Drug;
import org.example.java142_project.entity.Drugs;
import org.example.java142_project.entity.Support;

import java.util.List;
import java.util.Map;

public interface DrugService {
//    药品类别
    List<Drug> listDrugAll() throws ServiceException;
    boolean addDrug(Drug drug) throws ServiceException;
    boolean delDrug(int id) throws ServiceException;
//    供应商
    List<Support> listSupportAll() throws ServiceException;
    boolean addSupport(Support support) throws ServiceException;
    boolean delSupport(int id) throws ServiceException;
//    药品drugs
    List<Drugs> listDrugsAll() throws ServiceException;
    boolean addDrugs(Drugs drugs) throws ServiceException;
    boolean delDrugs(int id) throws ServiceException;
}
