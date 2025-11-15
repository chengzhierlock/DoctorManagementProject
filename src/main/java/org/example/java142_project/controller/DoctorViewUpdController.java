package org.example.java142_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.java142_project.common.constant.Information;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.common.ui.UIConstant;
import org.example.java142_project.common.ui.UIMyManager;
import org.example.java142_project.common.util.AlertUtil;
import org.example.java142_project.entity.Dept;
import org.example.java142_project.entity.Doctor;
import org.example.java142_project.entity.Education;
import org.example.java142_project.entity.Job;
import org.example.java142_project.service.DoctorService;
import org.example.java142_project.service.impl.DoctorServiceImpl;
import org.example.java142_project.util.DoctorViewUpdUtil;
import org.example.java142_project.vo.DoctorVO;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class DoctorViewUpdController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        获取缓存信息
        Map<Integer, DoctorVO> map = DoctorViewUpdUtil.getLocal().get();
//        for (Map.Entry<Integer, DoctorVO> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        if (map != null && map.containsKey(Information.DOCTORVIEWSTATE)) {
            DoctorVO doctorVO = map.get(Information.DOCTORVIEWSTATE);
            showInfo(doctorVO);
            titleInfo.setText("查看医生信息");
            butInfo.setVisible(false);
//            butInfo.setText("查看信息");
            iconCom.setVisible(false);
        } else if (map != null && map.containsKey(Information.DOCTORSETSTATE)) {
            DoctorVO doctorVO = map.get(Information.DOCTORSETSTATE);
            showInfo(doctorVO);
            loginnameRef.setDisable(true);
            titleInfo.setText("修改医生信息");
            butInfo.setText("修改信息");
            iconCom.setDisable(false);
            iconCom.getItems().addAll("/imgs/icon1.jpg","/imgs/icon2.jpg","/imgs/icon3.jpg","/imgs/icon4.jpg","/imgs/icon5.jpg");
            try {
                List<Job> jobs = doctorService.listJobAll();
                List<Dept> depts = doctorService.listDepAll();
                List<Education> educations = doctorService.listEduAll();
                jobCom.getItems().addAll(jobs);
                deptCom.getItems().addAll(depts);
                eduCom.getItems().addAll(educations);
            } catch (ServiceException e) {
                throw new RuntimeException();
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
            iconCom.setValue(doctorVO.getIconimg());
        }
    }

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
    public Label titleInfo;
    public Button butInfo;

    private int jobid;
    private int departid;
    private int eduid;
    private String iconImg;
    private ToggleGroup group = new ToggleGroup();
    private DoctorService doctorService = new DoctorServiceImpl();

    public void listDocHandle(ActionEvent actionEvent) {
    }

    public void showInfo(DoctorVO doctorVO) {
        loginnameRef.setText(doctorVO.getLoginName());
        nameRef.setText(doctorVO.getName());
        birthdayDate.setValue(LocalDate.parse(doctorVO.getBirthday()));
        if (doctorVO.getGender().equals("男")) {
            maleRadio.setSelected(true);
        } else {
            femaleRadio.setSelected(true);
        }
        jobid = doctorVO.getJoid();
        departid = doctorVO.getDeid();
        eduid = doctorVO.getEdid();
        try {
            jobCom.setValue(doctorService.finaOneJob(jobid));
            deptCom.setValue(doctorService.findOneDept(departid));
            eduCom.setValue(doctorService.findOneEdu(eduid));
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        Image img = new Image(getClass().getResourceAsStream(doctorVO.getIconimg()));
        iconView.setImage(img);
    }

    public void chooseImg(ActionEvent actionEvent) {
        String selectedItem = iconCom.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Image img = new Image(getClass().getResourceAsStream(selectedItem));
            iconView.setImage(img);
            this.iconImg = selectedItem;
        }
    }

    public void editDocHandle(ActionEvent actionEvent) {
        if (nameRef.equals("")) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        Doctor doctor = new Doctor();
        doctor.setName(nameRef.getText());
        doctor.setGender(maleRadio.isSelected() ? "男" : "女");
        doctor.setBirthday(birthdayDate.getValue().toString());
        doctor.setIconimg(this.iconImg);
        doctor.setJoid(this.jobid);
        doctor.setDeid(this.departid);
        doctor.setEdid(this.eduid);
        doctor.setDid(DoctorViewUpdUtil.getLocal().get().get(Information.DOCTORSETSTATE).getDid());
        try {
            boolean b = doctorService.editDoctor(doctor);
            if (b) {
                AlertUtil.showInfo("操作成功", Information.UpdateOK);
                UIMyManager.show(MainController.nodeList, UIConstant.DOC_SET);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
