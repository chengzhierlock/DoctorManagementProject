package org.example.java142_project.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import org.example.java142_project.common.ui.UIConstant;
import org.example.java142_project.common.ui.UIMyManager;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public AnchorPane mainFrame;

    public static ObservableList<Node> nodeList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        加载所有页面
        new Thread(() -> UIMyManager.initView()).start();
        nodeList = mainFrame.getChildren();
    }

    public void docAddHandle(ActionEvent actionEvent) {
        UIMyManager.show(nodeList, UIConstant.DOC_ADD);
    }

    public void docSetHandle(ActionEvent actionEvent) {
        UIMyManager.show(nodeList, UIConstant.DOC_SET);
    }
}
