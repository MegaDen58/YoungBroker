package com.example.young;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LessonController implements Initializable {
    int counter = 0;
    @FXML
    Label labelText, labelCounter;

    List<String> text = new ArrayList<>();
    String stringCounter;
    @FXML
    ImageView backButton;
    public void goNext() {
        if(counter < text.size()){
            counter++;
            stringCounter = String.format("%s | %s", counter, text.size());
            labelCounter.setText(stringCounter);

            labelText.setText(text.get(counter - 1));
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    public void goBack() {
        if(counter > 0){
            counter--;
            stringCounter = String.format("%s | %s", counter + 1, text.size());
            labelCounter.setText(stringCounter);

            labelText.setText(text.get(counter));
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\lesson.txt"))){
            while((line = br.readLine()) != null){
                text.add(line);
            }
            labelText.setText(text.get(0));
            stringCounter = String.format("%s | %s", counter + 1, text.size());
            labelCounter.setText(stringCounter);
        } catch (Exception exception){

        }
    }

    public void goMain() throws Exception{
        Stage thisStage = (Stage) backButton.getScene().getWindow();
        thisStage.close();

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}