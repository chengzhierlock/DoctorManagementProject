package org.example.java142_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.java142_project.common.constant.Information;
import org.example.java142_project.common.controller.BaseController;
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
import com.example.java142_project.common.util.PageUtil;
import org.example.java142_project.util.DoctorViewUpdUtil;
import org.example.java142_project.vo.DoctorVO;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class DoctorSetController extends BaseController implements Initializable {
    public TableView docTab;
    public Label pageInfoRef;
    public TableColumn nameCol;
    public TableColumn genderCol;
    public TableColumn birthdayCol;
    public TableColumn jobnameCol;
    public TableColumn departnameCol;
    public TableColumn ednameCol;
    public TableColumn didCol;
    public TableColumn loginNameCol;
    public TextField nameRef;
    public RadioButton maleRad;
    public RadioButton femaleRad;
    private DoctorService doctorService = new DoctorServiceImpl();
    private PageUtil pageUtil = new PageUtil();
    private Map<String,String> map = new HashMap<>();
    ObservableList<DoctorVO> docObj = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        maleRad.setToggleGroup(toggleGroup);
        femaleRad.setToggleGroup(toggleGroup);
        showAll();
        loadPageInfo();
    }

    public ComboBox<Job> jobCom;
    public ComboBox<Education> eduCom;
    public ComboBox<Dept> deptCom;
    private int jobid;
    private int departid;
    private int eduid;
    private ToggleGroup toggleGroup = new ToggleGroup();

    public void addDocHandle(ActionEvent actionEvent) {
        UIMyManager.show(MainController.nodeList, UIConstant.DOC_ADD);
    }

    public void colToPropertie() {
        this.colToProper(DoctorSetController.class);
    }

    public void showAll() {
        colToPropertie();
        docObj.clear();
        try {
            int count = doctorService.CountInfo(map);
            pageUtil.setTotalCount(count);
            pageUtil.setPageNum();
            pageUtil.setCurrentPage(pageUtil.getCurrentPage());
            map.put("pages",String.valueOf(pageUtil.getCurrentPage()));
            map.put("size",String.valueOf(pageUtil.getPageSize()));
            if (count > 0) {
                docObj.addAll(doctorService.listDoctorAll(map));
                docTab.setItems(docObj);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadPageInfo() {
        pageInfoRef.setText("总记录数"+pageUtil.getTotalCount()+",当前页:"+pageUtil.getCurrentPage()+",总页数:"+pageUtil.getPageNum());
    }


    public void firstPage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(1);
        showAll();
        loadPageInfo();
    }

    public void prePage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(pageUtil.getCurrentPage()-1);
        showAll();
        loadPageInfo();
    }

//    构建查询条件
    private void queryCond() {
        map.clear();
        if(!nameRef.getText().equals("")) {
            map.put("name",nameRef.getText());
        }
        if (!toggleGroup.getSelectedToggle().equals("")) {
            if (toggleGroup.getSelectedToggle().equals(maleRad)) {
                map.put("gender","男");
            } else if (toggleGroup.getSelectedToggle().equals(femaleRad)) {
                map.put("gender","女");
            }
//            map.put("gender",toggleGroup.getSelectedToggle().toString());
            if (jobid != 0) {
                map.put("joid",String.valueOf(jobid));
            }
            if (departid != 0) {
                map.put("deid",String.valueOf(departid));
            }
            if (eduid != 0) {
                map.put("edid",String.valueOf(eduid));
            }
        }
    }

//    查询信息按钮处理
    public void queryHandle(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(1);
        pageUtil.setPageSize(2);
        queryCond();
        showAll();
        loadPageInfo();
    }

    public void nextPage(ActionEvent actionEvent) {
        if (pageUtil.getCurrentPage() < pageUtil.getPageNum()) {
            pageUtil.setCurrentPage(pageUtil.getCurrentPage() + 1);
            showAll();
            loadPageInfo();
        }
    }

    public void lastPage(ActionEvent actionEvent) {
        if (pageUtil.getPageNum() > 0) {
            pageUtil.setCurrentPage(pageUtil.getPageNum());
            showAll();
            loadPageInfo();
        }
    }

    public void refreshData(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(1);
        pageUtil.setPageSize(4);
        map.clear();
        showAll();
        loadPageInfo();
        this.departid = 0;
        this.eduid = 0;
        this.jobid = 0;
        clearData();
    }

//    清除下拉框内容
    private void clearData() {
        nameRef.setText("");
        maleRad.setSelected(false);
        femaleRad.setSelected(false);
        jobCom.getSelectionModel().clearSelection();
        deptCom.getSelectionModel().clearSelection();
        eduCom.getSelectionModel().clearSelection();
    }

    public void viewDocHandle(ActionEvent actionEvent) {
        DoctorVO selectedItem = (DoctorVO)docTab.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            AlertUtil.showError("请选择要查看的医生");
            return;
        }
        Map<Integer,DoctorVO> map = new HashMap<>();
        map.put(Information.DOCTORVIEWSTATE,selectedItem);
        DoctorViewUpdUtil.setLocal(map);
        UIMyManager.show(MainController.nodeList,UIConstant.DOC_VIEW_UPD);
    }


    public void updDocHandle(ActionEvent actionEvent) {
        DoctorVO selectedItem = (DoctorVO)docTab.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            AlertUtil.showError("请选择要更新的医生");
            return;
        }
        Map<Integer,DoctorVO> map = new HashMap<>();
        map.put(Information.DOCTORSETSTATE,selectedItem);
        DoctorViewUpdUtil.setLocal(map);
        UIMyManager.show(MainController.nodeList,UIConstant.DOC_VIEW_UPD);
    }

    public void delDoctorHandle(ActionEvent actionEvent) {
        DoctorVO selectedItem = (DoctorVO)docTab.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            AlertUtil.showError("请选择要删除的医生");
            return;
        }
        try {
            boolean b = doctorService.delDoctor(selectedItem.getDid());
            if (b) {
                AlertUtil.showInfo("删除成功");
                showAll();
                loadPageInfo();
            } else {
                AlertUtil.showError("删除失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
