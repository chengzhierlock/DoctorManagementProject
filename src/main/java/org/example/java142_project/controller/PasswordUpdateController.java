package org.example.java142_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import org.example.java142_project.common.constant.Information;
import org.example.java142_project.common.controller.BaseController;
import org.example.java142_project.common.exception.ServiceException;
import org.example.java142_project.common.ui.UIConstant;
import org.example.java142_project.common.ui.UIMyManager;
import org.example.java142_project.common.util.AlertUtil;
import org.example.java142_project.service.LoginService;
import org.example.java142_project.service.impl.LoginServiceImpl;
import org.example.java142_project.util.LoginInfoUtil;
import org.example.java142_project.vo.AdminVO;
import org.example.java142_project.vo.DoctorVO;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class PasswordUpdateController extends BaseController implements Initializable {

    public PasswordField oldPasswordRef;
    public PasswordField newPasswordRef;
    public PasswordField confirmPasswordRef;

    private LoginService loginService = new LoginServiceImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 初始化代码（如果需要）
    }

    public void updatePasswordHandle(ActionEvent actionEvent) {
        try {
            // 获取输入的值
            String oldPassword = oldPasswordRef.getText().trim();
            String newPassword = newPasswordRef.getText().trim();
            String confirmPassword = confirmPasswordRef.getText().trim();

            // 验证输入是否为空
            if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                AlertUtil.showError("操作失败", "请填写所有密码字段");
                return;
            }

            // 验证新密码和确认密码是否相同
            if (!newPassword.equals(confirmPassword)) {
                AlertUtil.showError("操作失败", "新密码和确认密码不一致");
                return;
            }

            // 验证新密码是否与原密码不同
            if (oldPassword.equals(newPassword)) {
                AlertUtil.showError("操作失败", "新密码不能与原密码相同");
                return;
            }

            // 获取当前登录用户信息
            Map<Integer, Object> loginInfo = LoginInfoUtil.getLoginInfo();
            String loginname = "";

            if (loginInfo != null) {
                if (loginInfo.get(Information.MANAGER) != null) {
                    // 管理员
                    AdminVO adminVO = (AdminVO) loginInfo.get(Information.MANAGER);
                    loginname = adminVO.getLoginname();
                } else if (loginInfo.get(Information.DOCTOR) != null) {
                    // 医生 - 根据你的DoctorVO实际字段名调整
                    DoctorVO doctorVO = (DoctorVO) loginInfo.get(Information.DOCTOR);
                    // 尝试不同的可能字段名
                    if (doctorVO.getLoginName() != null) {
                        loginname = doctorVO.getLoginName();
                    } else if (doctorVO.getLoginName() != null) {
                        loginname = doctorVO.getLoginName();
                    } else {
                        // 如果DoctorVO没有登录名字段，可能需要从其他方式获取
                        loginname = doctorVO.getName(); // 或者使用其他字段
                    }
                }
            }

            if (loginname.isEmpty()) {
                AlertUtil.showError("操作失败", "无法获取用户登录名，请重新登录");
                return;
            }

            // 调用服务层更新密码
            boolean success = loginService.updatePassword(loginname, oldPassword, newPassword);

            if (success) {
                AlertUtil.showInfo("操作成功", "密码修改成功");
                // 清除表单
                clearForm();
                // 返回主界面
                UIMyManager.show(MainController.nodeList, UIConstant.DOC_SET);
            }

        } catch (ServiceException e) {
            // Service层已经处理了业务异常，直接显示错误信息
            AlertUtil.showError("操作失败", e.getMessage());
        } catch (Exception e) {
            // 处理其他未知异常
            AlertUtil.showError("系统错误", "修改密码时发生未知错误");
            e.printStackTrace();
        }
    }

    public void backToMainHandle(ActionEvent actionEvent) {
        // 返回主界面
        UIMyManager.show(MainController.nodeList, UIConstant.DOC_SET);
    }

    private void clearForm() {
        oldPasswordRef.setText("");
        newPasswordRef.setText("");
        confirmPasswordRef.setText("");
    }
}