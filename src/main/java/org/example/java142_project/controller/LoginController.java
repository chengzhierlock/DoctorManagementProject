package org.example.java142_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.java142_project.common.constant.Information;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.common.util.AlertUtil;
import org.example.java142_project.common.util.ViewUtil;
import org.example.java142_project.entity.Login;
import org.example.java142_project.service.LoginService;
import org.example.java142_project.service.impl.LoginServiceImpl;
import org.example.java142_project.util.LoginInfoUtil;
import org.example.java142_project.vo.AdminVO;
import org.example.java142_project.vo.DoctorVO;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField unameRef;
    public TextField passRef;
    public RadioButton manager;
    public RadioButton doctor;

    private LoginService loginService = new LoginServiceImpl();
    private ToggleGroup group = new ToggleGroup();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manager.setToggleGroup(group);
        doctor.setToggleGroup(group);
        manager.setSelected(true);
    }

    public void loginHandle(ActionEvent actionEvent) {
        String name = unameRef.getText();
        String pass = passRef.getText();
        if (name.equals("") || pass.equals("")) {
            AlertUtil.showError("操作失败", Information.FULLDATA);
            return;
        }
        try {
            Login login = loginService.isLogin(name,pass);
            if (login != null) {
                int roleid = login.getRoleid();
                if ((manager.isSelected() && roleid == Information.MANAGER) || (doctor.isSelected() && roleid == Information.DOCTOR)) {
//                    存储个人登录信息
                    Map<Integer,Object> map = new HashMap<>();
                     AlertUtil.showInfo(Information.LOGINOK);
                     if (roleid == Information.MANAGER) {
                         AdminVO adminLoginInfo = loginService.getAdminLoginInfo(login.getId());
                         map.put(Information.MANAGER,adminLoginInfo);
                     } else {
                         DoctorVO doctorLoginInfo = loginService.getDocLoginInfo(login.getId());
                         map.put(Information.DOCTOR,doctorLoginInfo);
                     }
//                     存入缓存
                     LoginInfoUtil.setLoginInfo(map);
                     AlertUtil.showInfo(Information.LOGINOK);
                    ViewUtil.start("/org/example/java142_project/main.fxml","系统管理");
                    ViewUtil.close(unameRef);
                } else {
                    AlertUtil.showInfo(Information.ROLEERROR);
                }
            } else {
                AlertUtil.showError("操作失败", Information.LOGINFAIL);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
