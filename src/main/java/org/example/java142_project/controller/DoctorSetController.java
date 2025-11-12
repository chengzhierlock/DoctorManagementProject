package org.example.java142_project.controller;

import javafx.event.ActionEvent;
import org.example.java142_project.common.ui.UIConstant;
import org.example.java142_project.common.ui.UIMyManager;

public class DoctorSetController {

    public void addDocHandle(ActionEvent actionEvent) {
        UIMyManager.show(MainController.nodeList, UIConstant.DOC_ADD);
    }
}
