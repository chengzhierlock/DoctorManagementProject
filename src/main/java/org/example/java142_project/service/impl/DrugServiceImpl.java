package org.example.java142_project.service.impl;

import org.example.java142_project.common.exception.DAOException;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.dao.DrugDAO;
import org.example.java142_project.dao.DrugsDAO;
import org.example.java142_project.dao.SupportDAO;
import org.example.java142_project.dao.impl.DrugDAOImpl;
import org.example.java142_project.dao.impl.DrugsDAOImpl;
import org.example.java142_project.dao.impl.SupportDAOImpl;
import org.example.java142_project.entity.Drug;
import org.example.java142_project.entity.Drugs;
import org.example.java142_project.entity.Login;
import org.example.java142_project.entity.Support;
import org.example.java142_project.service.DrugService;

import java.util.List;
import java.util.Map;

public class DrugServiceImpl implements DrugService {
    private DrugDAO drugDAO = new DrugDAOImpl();
    private SupportDAO supportDAO = new SupportDAOImpl();
    private DrugsDAO drugsDAO = new DrugsDAOImpl();
    @Override
    public List<Drug> listDrugAll() throws ServiceException {
        try {
            return drugDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addDrug(Drug drug) throws ServiceException {
        try {
            return drugDAO.insert(drug);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delDrug(int id) throws ServiceException {
        try {
            return drugDAO.del(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Support> listSupportAll() throws ServiceException {
        try {
            return supportDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addSupport(Support support) throws ServiceException {
        try {
            return supportDAO.insert(support);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delSupport(int id) throws ServiceException {
        try {
            return supportDAO.del(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Drugs> listDrugsAll() throws ServiceException {
        try {
            return drugsDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addDrugs(Drugs drugs) throws ServiceException {
        try {
            return drugsDAO.insert(drugs);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delDrugs(int id) throws ServiceException {
        try {
            return drugsDAO.del(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
