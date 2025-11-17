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
import org.example.java142_project.entity.Drug;
import org.example.java142_project.entity.Drugs;
import org.example.java142_project.entity.Job;
import org.example.java142_project.entity.Support;
import org.example.java142_project.service.DrugService;
import org.example.java142_project.service.impl.DrugServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DrugAddController extends BaseController implements Initializable {

    public TableView supportTab;
    public TableColumn supnameCol;
    public TableColumn telCol;
    public TableColumn emailCol;
    public TableColumn addressCol;
    public TableColumn supdescCol;
    public TextField supnameRef;
    public TextField telRef;
    public TextField emailRef;
    public TextField addressRef;
    public TextField supdescRef;
    public TextField cnameRef;
    public TextField cdescpRef;
    public TableColumn cidCol;
    public TableColumn cnameCol;
    public TableColumn cdescpCol;
    public TableColumn lastdateCol;
    public TableView drugtypeTab;
    public TextField drugnameRef;
    public TextField priceRef;
    public TextField stockRef;
    public TextField drugunitRef;
    public DatePicker productdate;
    public DatePicker effectdate;
    public TextArea descpRef;
    public ComboBox<Drug> drugtypeCom;
    public ComboBox<Support> supportCom;

    private int suid;
    private int cid;

    ObservableList<Drug> drugObj = FXCollections.observableArrayList();
    ObservableList<Support> supportObj = FXCollections.observableArrayList();
    private DrugService drugService = new DrugServiceImpl();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            List<Drug> drug = drugService.listDrugAll();
            List<Support> supports = drugService.listSupportAll();
            drugtypeCom.getItems().addAll(drug);
            supportCom.getItems().addAll(supports);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        drugtypeCom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null) {
                return;
            }
            cid = newValue.getCid();
        });
        supportCom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null) {
                return;
            }
            suid = newValue.getSupportid();
        });

        colToPropertie();
        loadData();
    }

    public void colToPropertie() {
        this.colToProper(DrugAddController.class);
    }

    public void loadData() {
        colToPropertie();
        List<Drug> drugs = null;
        List<Support> supports = null;
        try {
            drugs = drugService.listDrugAll();
            supports = drugService.listSupportAll();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        showData(drugs,supports);
    }

    public void showData(List<Drug> drugs,List<Support> supports) {
        drugObj.clear();
        supportObj.clear();
        for (int i = 0;i<drugs.size();i++) {
            drugObj.add(drugs.get(i));
        }for (int i = 0;i<supports.size();i++) {
            supportObj.add(supports.get(i));
        }
        drugtypeTab.setItems(drugObj);
        supportTab.setItems(supportObj);
    }

    public void addDrugHandle(ActionEvent actionEvent) {
        if(cnameRef.getText().equals("")||cdescpRef.getText().equals("")) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        Drug drug = (Drug)this.createObject(DrugAddController.class, Drug.class);
        try {
            drugService.addDrug(drug);
            AlertUtil.showInfo("操作成功", Information.AddOK);
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("添加类别时发生错误", "错误信息：" + e.getMessage());
        }
    }

    public void delDrugHandle(ActionEvent actionEvent) {

        Drug drug = (Drug)drugtypeTab.getSelectionModel().getSelectedItem();
        if (drug == null) {
            System.out.println("没有选中任何药品");
            AlertUtil.showError("操作失败", Information.CHOOSEDEL);
            return;
        }
        try {
            drugService.delDrug(drug.getCid());

            AlertUtil.showInfo("操作成功", "删除成功！");
            loadData();

        } catch (ServiceException e) {
            e.printStackTrace(); // 打印完整堆栈信息
            AlertUtil.showError("删除失败", "错误信息：" + e.getMessage());
        }
    }

    public void addSupportHandle(ActionEvent actionEvent) {
        if(supnameRef.getText().equals("")||telRef.getText().equals("")||emailRef.getText().equals("")||addressRef.getText().equals("")||supdescRef.getText().equals("")) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        Support support = (Support)this.createObject(DrugAddController.class, Support.class);
        try {
            drugService.addSupport(support);
            AlertUtil.showInfo("操作成功", Information.AddOK);
            loadData();
        } catch (ServiceException e) {
            AlertUtil.showError("添加类别时发生错误", "错误信息：" + e.getMessage());
        }
    }

    public void delSupportHandle(ActionEvent actionEvent) {
        Support support = (Support)supportTab.getSelectionModel().getSelectedItem();
        if (support == null) {
            System.out.println("没有选中任何供应商");
            AlertUtil.showError("操作失败", Information.CHOOSEDEL);
            return;
        }
        try {
            drugService.delSupport(support.getSupportid());
            AlertUtil.showInfo("操作成功", "删除成功！");
            loadData();
        } catch (ServiceException e) {
            e.printStackTrace(); // 打印完整堆栈信息
            AlertUtil.showError("删除失败", "错误信息：" + e.getMessage());
        }
    }

//    上面的方法应该是adddrugtype,这里加s是区分添加具体的药品而不是类别
    public void addDrugsHandle(ActionEvent actionEvent) {
        if (drugnameRef.getText().isEmpty() ||
                priceRef.getText().isEmpty() ||
                stockRef.getText().isEmpty() ||
                drugunitRef.getText().isEmpty() ||
                productdate.getValue() == null ||
                effectdate.getValue() == null ||
                drugtypeCom.getValue() == null ||  // 检查ComboBox是否选中
                supportCom.getValue() == null ||    // 检查ComboBox是否选中
                descpRef.getText().isEmpty()) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        Drugs drugs = new Drugs();
        drugs.setDrugname(drugnameRef.getText());
        drugs.setDrugtype(cid);
        drugs.setDrugunit(drugunitRef.getText());
        drugs.setSupport(suid);
        drugs.setDescp(descpRef.getText());
        drugs.setStock(Integer.parseInt(stockRef.getText()));
        drugs.setProductdate(productdate.getValue().toString());
        drugs.setEffectdate(effectdate.getValue().toString());
        drugs.setPrice(Float.parseFloat(priceRef.getText()));
        try {
            drugService.addDrugs(drugs);
            AlertUtil.showInfo("操作成功", Information.AddOK);
            listDrugsHandle(actionEvent);
        } catch (ServiceException e) {
            AlertUtil.showError("添加药品时发生错误", "错误信息：" + e.getMessage());
        }
    }

    public void listDrugsHandle(ActionEvent actionEvent) {
        UIMyManager.show(MainController.nodeList, UIConstant.DRUG_SET);
    }
}
