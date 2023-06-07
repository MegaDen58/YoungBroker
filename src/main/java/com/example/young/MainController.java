package com.example.young;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
    @FXML
    Button stockButton;
    public void goToStock() throws Exception{
        Stage thisStage = (Stage) stockButton.getScene().getWindow();
        thisStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 518, 318);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void goToLesson() throws Exception{
        Stage thisStage = (Stage) stockButton.getScene().getWindow();
        thisStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("lesson.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 513);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void goToBackpack() throws Exception{
        Stage thisStage = (Stage) stockButton.getScene().getWindow();
        thisStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("table.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
