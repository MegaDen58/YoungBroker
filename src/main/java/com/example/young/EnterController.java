package com.example.young;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterController implements Initializable {
    @FXML
    TextField price, count;
    @FXML
    ImageView imageView, imageBack;
    @FXML
    Button addButton;
    @FXML
    Label label;
    String tag;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(HelloController.name);
        tag = HelloController.name.split("\\(")[1].replace(")", "");
        imageView.setImage(new Image(String.format("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\picture\\%s.png", tag)));
    }

    public void add(){
        String name = label.getText();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\backpack.txt", true))){
            double price1 = Double.parseDouble(price.getText());
            int count1 = Integer.parseInt(count.getText());

            bw.write(String.format("%s:%s:%s\n", name, price1, count1));
            bw.flush();

            Stage thisStage = (Stage) addButton.getScene().getWindow();
            thisStage.close();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 518, 318);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Акция добавлена");
            alert.showAndWait();
        } catch (Exception exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    public void goBack() throws Exception{
        Stage thisStage = (Stage) imageBack.getScene().getWindow();
        thisStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 518, 318);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
