package org.example.java142_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.java142_project.common.constant.Information;
import org.example.java142_project.common.controller.BaseController;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.common.ui.UIConstant;
import org.example.java142_project.common.ui.UIMyManager;
import org.example.java142_project.common.util.AlertUtil;
import org.example.java142_project.entity.*;
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
    public ComboBox<Job> jobCom;
    public ComboBox<Dept> deptCom;
    public ComboBox<Education> eduCom;
    public ComboBox<String> iconCom;
    public ImageView iconView;
    public TextField loginnameRef;
    public TextField nameRef;
    public DatePicker birthdayDate;
    public RadioButton maleRadio;
    public RadioButton femaleRadio;
    ObservableList<Job> jobObj = FXCollections.observableArrayList();
    ObservableList<Education> eduObj = FXCollections.observableArrayList();
    ObservableList<Dept> deptObj = FXCollections.observableArrayList();
    private int jobid;
    private int departid;
    private int eduid;
    private String iconImg;
    private ToggleGroup group = new ToggleGroup();
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
        maleRadio.setToggleGroup(group);
        femaleRadio.setToggleGroup(group);
        maleRadio.setSelected(true);
//        所有职称
        try {
            List<Job> jobs = doctorService.listJobAll();
            List<Dept> depts = doctorService.listDepAll();
            List<Education> educations = doctorService.listEduAll();
            jobCom.getItems().addAll(jobs);
            deptCom.getItems().addAll(depts);
            eduCom.getItems().addAll(educations);
            iconCom.getItems().addAll("/imgs/icon1.jpg","/imgs/icon2.jpg","/imgs/icon3.jpg","/imgs/icon4.jpg","/imgs/icon5.jpg");
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        jobCom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                return;
            }
            jobid = newValue.getJobid();
        });
        deptCom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                return;
            }
            departid = newValue.getDeptid();
        });
        eduCom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                return;
            }
            eduid = newValue.getEid();
        });
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

    public void chooseImg(ActionEvent actionEvent) {
        String selectedItem = iconCom.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Image img = new Image(getClass().getResourceAsStream(selectedItem));
            iconView.setImage(img);
            this.iconImg = selectedItem;
        }
    }

    public void addDoctorHandle(ActionEvent actionEvent) {
        if(loginnameRef.equals("")||nameRef.equals("")) {
            AlertUtil.showError("添加失败", Information.FULLDATA);
            return;
        }
        Login login = new Login();
        login.setLoginname(loginnameRef.getText());
        Doctor doctor = new Doctor();
        doctor.setName(nameRef.getText());
        doctor.setBirthday(birthdayDate.getValue().toString());
        doctor.setGender(maleRadio.isSelected()?"男":"女");
        doctor.setJoid(this.jobid);
        doctor.setDeid(this.departid);
        doctor.setEdid(this.eduid);
        try {
            doctorService.addDoctor(login,doctor);
            AlertUtil.showInfo("添加成功", Information.AddOK);
            UIMyManager.show(MainController.nodeList,UIConstant.DOC_SET);
        } catch (ServiceException e) {
            AlertUtil.showError("错误", "添加失败" + e.getMessage());
        }

    }
}
