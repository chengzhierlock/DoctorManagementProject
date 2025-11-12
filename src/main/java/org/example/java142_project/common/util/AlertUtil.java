package org.example.java142_project.common.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * 弹窗工具类
 */
public class AlertUtil {

    /**
     * 显示信息提示框
     * @param message 提示信息
     */
    public static void showInfo(String message) {
        showAlert(Alert.AlertType.INFORMATION, "操作成功", null, message);
    }

    /**
     * 显示信息提示框（带标题）
     * @param title 标题
     * @param message 提示信息
     */
    public static void showInfo(String title, String message) {
        showAlert(Alert.AlertType.INFORMATION, title, null, message);
    }

    /**
     * 显示错误提示框
     * @param message 错误信息
     */
    public static void showError(String message) {
        showAlert(Alert.AlertType.ERROR, "操作失败", null, message);
    }

    /**
     * 显示错误提示框（带标题）
     * @param title 标题
     * @param message 错误信息
     */
    public static void showError(String title, String message) {
        showAlert(Alert.AlertType.ERROR, title, null, message);
    }

    /**
     * 显示警告提示框
     * @param message 警告信息
     */
    public static void showWarning(String message) {
        showAlert(Alert.AlertType.WARNING, "警告", null, message);
    }

    /**
     * 显示确认对话框
     * @param message 确认信息
     * @return 用户是否确认
     */
    public static boolean showConfirm(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("确认操作");
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    /**
     * 显示确认对话框（带标题）
     * @param title 标题
     * @param message 确认信息
     * @return 用户是否确认
     */
    public static boolean showConfirm(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    /**
     * 通用弹窗方法
     * @param alertType 弹窗类型
     * @param title 标题
     * @param header 头部信息
     * @param content 内容信息
     */
    public static void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}