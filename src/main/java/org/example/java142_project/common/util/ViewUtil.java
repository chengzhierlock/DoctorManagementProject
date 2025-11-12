package org.example.java142_project.common.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtil {
    public static void start(String url, String title) {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(ViewUtil.class.getResource(url));
            Scene scene = new Scene(root,1000,700);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Parent parent) {
        Stage stage = (Stage) parent.getScene().getWindow();
        stage.close();
    }
}
