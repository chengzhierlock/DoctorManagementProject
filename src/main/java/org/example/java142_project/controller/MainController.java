package org.example.java142_project.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.example.java142_project.common.constant.Information;
import org.example.java142_project.common.ui.UIConstant;
import org.example.java142_project.common.ui.UIMyManager;
import org.example.java142_project.util.LoginInfoUtil;
import org.example.java142_project.vo.AdminVO;
import org.example.java142_project.vo.DoctorVO;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public AnchorPane mainFrame;

    public static ObservableList<Node> nodeList;
    public ImageView iconView;
    public Label nameLab;
    public Label genderLab;
    public Label roleLab;
    public Menu userMenu;
    public Menu drugMenu;
    public Menu patientMenu;
    public Menu anaMenu;
    public Menu aiMenu;
    public Menu sysMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        加载所有页面
        new Thread(() -> UIMyManager.initView()).start();
//        二级菜单通过观察者列表实现
        nodeList = mainFrame.getChildren();
//        获取登录信息
        Map<Integer, Object> loginInfo = LoginInfoUtil.getLoginInfo();
        if (loginInfo!=null) {
            if (loginInfo.get(Information.MANAGER) != null) {
                AdminVO adminVO = (AdminVO) loginInfo.get(Information.MANAGER);
                nameLab.setText(adminVO.getLoginname());
                roleLab.setText("管理员");
                genderLab.setText(adminVO.getGender());
                Image img = new Image(getClass().getResourceAsStream(adminVO.getIconimg()));
                iconView.setImage(img);

            } else {
                DoctorVO doctorVO = (DoctorVO) loginInfo.get(Information.DOCTOR);
                nameLab.setText(doctorVO.getName());
                roleLab.setText("医生");
                genderLab.setText(doctorVO.getGender());
                Image img = new Image(getClass().getResourceAsStream(doctorVO.getIconimg()));
                iconView.setImage(img);
                userMenu.setVisible(false);
                drugMenu.setVisible(false);
                patientMenu.setVisible(false);
                anaMenu.setVisible(false);
            }
        }
    }

    public void docAddHandle(ActionEvent actionEvent) {
        UIMyManager.show(nodeList, UIConstant.DOC_ADD);
    }

    public void docSetHandle(ActionEvent actionEvent) {
        UIMyManager.show(nodeList, UIConstant.DOC_SET);
    }
}
