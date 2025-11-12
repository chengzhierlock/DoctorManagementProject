package org.example.java142_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.java142_project.common.constant.Information;
import org.example.java142_project.common.controller.BaseController;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.common.ui.UIConstant;
import org.example.java142_project.common.ui.UIMyManager;
import org.example.java142_project.common.util.AlertUtil;
import org.example.java142_project.entity.Dept;
import org.example.java142_project.entity.Education;
import org.example.java142_project.entity.Job;
import org.example.java142_project.service.DoctorService;
import org.example.java142_project.service.impl.DoctorServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DoctorAddController extends BaseController implements Initializable {
    public TableView jobTab;
    public TableColumn jobidCol;
    public TableColumn jobnameCol;
    public TableColumn jobdescpCol;
    public TextField jobnameRef;
    public TextField jobdescpRef;
    public TextField enameRef;
    public TableView eduTab;
    public TableColumn eidCol;
    public TableColumn enameCol;
    public TableColumn edescpCol;
    public TextField edescpRef;
    public TextField deptnameRef;
    public TextField deptdescpRef;
    public TableView deptTab;
    public TableColumn deptidCol;
    public TableColumn deptnameCol;
    ObservableList<Job> jobObj = FXCollections.observableArrayList();
    ObservableList<Education> eduObj = FXCollections.observableArrayList();
    ObservableList<Dept> deptObj = FXCollections.observableArrayList();
    private DoctorService doctorService = new DoctorServiceImpl();
    public void colToPropertie() {
        this.colToProper(DoctorAddController.class);
    }
    public void loadData() {
        colToPropertie();
        List<Job> jobs = null;
        List<Education> educations = null;
        List<Dept> depts = null;
        try {
            jobs = doctorService.listJobAll();
            educations = doctorService.listEduAll();
            depts = doctorService.listDepAll();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        showData(jobs,educations,depts);
    }

    public void showData(List<Job> jobs,List<Education> educations,List<Dept> depts) {
        jobObj.clear();
        eduObj.clear();
        deptObj.clear();
        for (int i = 0;i<jobs.size();i++) {
            jobObj.add(jobs.get(i));
        }
        for (int i=0;i<educations.size();i++) {
            eduObj.add(educations.get(i));
        }
        for (int i=0;i<depts.size();i++) {
            deptObj.add(depts.get(i));
        }
        jobTab.setItems(jobObj);
        eduTab.setItems(eduObj);
        deptTab.setItems(deptObj);
    }

    public void listDocHandle(ActionEvent actionEvent) {
        UIMyManager.show(MainController.nodeList, UIConstant.DOC_SET);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    loadData();
    }

    public void addJobHandle(ActionEvent actionEvent) {
        if(jobnameRef.getText().equals("")||jobdescpRef.getText().equals("")) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        Job job = (Job)this.createObject(DoctorAddController.class, Job.class);
        try {
            doctorService.addJob(job);
            AlertUtil.showInfo("操作成功", Information.AddOK);
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("添加职位时发生错误", "错误信息：" + e.getMessage());
        }
    }

    public void delJobHandle(ActionEvent actionEvent) {
        Job job = (Job)jobTab.getSelectionModel().getSelectedItem();
        if (job == null) {
            AlertUtil.showError("操作失败", Information.CHOOSEDEL);
            return;
        }
        try {
            doctorService.delJob(job.getJobid());
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("删除失败");
        }
    }

    public void addEduHandle(ActionEvent actionEvent) {
        if(enameRef.getText().equals("")||edescpRef.getText().equals("")) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        Education edu = (Education) this.createObject(DoctorAddController.class, Education.class);
        try {
            doctorService.addEducation(edu);
            AlertUtil.showInfo("操作成功", Information.AddOK);
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("添加学历时发生错误", "错误信息：" + e.getMessage());
        }
    }

    public void delEduHandle(ActionEvent actionEvent) {
        Education edu = (Education) eduTab.getSelectionModel().getSelectedItem();
        if (edu == null) {
            AlertUtil.showError("操作失败", Information.CHOOSEDEL);
            return;
        }
        try {
            doctorService.delEducation(edu.getEid());
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("删除失败");
        }
    }

    public void addDeptHandle(ActionEvent actionEvent) {
        if(deptnameRef.getText().equals("")||deptdescpRef.getText().equals("")) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        Dept dept = (Dept)this.createObject(DoctorAddController.class, Dept.class);
        try {
            doctorService.addDept(dept);
            AlertUtil.showInfo("操作成功", Information.AddOK);
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("添加科室时发生错误", "错误信息：" + e.getMessage());
        }
    }

    public void delDeptHandle(ActionEvent actionEvent) {
        Dept dept = (Dept) deptTab.getSelectionModel().getSelectedItem();
        if (dept == null) {
            AlertUtil.showError("操作失败", Information.CHOOSEDEL);
            return;
        }
        try {
            doctorService.delDept(dept.getDeptid());
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("删除失败");
        }
    }
}
