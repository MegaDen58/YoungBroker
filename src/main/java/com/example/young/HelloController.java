package com.example.young;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    @FXML
    private ListView<String> listView;
    @FXML
    ImageView backImg;
    public static String name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> items = FXCollections.observableArrayList();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\StockList.txt")))){
            String line;
            while((line = br.readLine()) != null){
                items.add(line);
            }
        } catch (Exception exception){

        }
        listView.getItems().addAll(items);

    }

    public void getSelected() throws Exception{
        Stage thisStage = (Stage) listView.getScene().getWindow();
        thisStage.close();
        Stage stage = new Stage();
        name = listView.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("enter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 384, 282);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void goBack() throws Exception{
        Stage thisStage = (Stage) backImg.getScene().getWindow();
        thisStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}