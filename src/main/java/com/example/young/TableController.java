package com.example.young;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    TableColumn<Table, String> colName;
    @FXML
    TableColumn<Table, Integer> colCount;
    @FXML
    TableColumn<Table, Double> colBuyPrice, colPriceNow, colPercent;
    @FXML
    TableView tableView;
    @FXML
    Label labelPrice, labelPriceNow, labelPercent;
    @FXML
    ImageView imageBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<Table> list = FXCollections.observableArrayList();
        double priceAll = 0;
        double priceAllNow = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\backpack.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String tag = Dop.getTag(line);
                priceAll += Dop.getPrice(tag);
                priceAllNow += Internet.getPrice(tag);
                int count = Dop.getCount(tag);
                double price = Dop.getPrice(tag);
                double priceNow = Internet.getPrice(tag);
                list.add(new Table(Dop.getName(line), count, price, priceNow, Double.parseDouble(String.format("%.2f", Dop.getPercent(price, priceNow)).replace(",","."))));
            }
            labelPrice.setText("Потраченная сумма: " + priceAll + "$");
            labelPriceNow.setText("Сумма сейчас: " + String.format("%.2f", priceAllNow) + "$");
            labelPercent.setText("Прибыль (% | $): " + String.format("%.2f | ", Dop.getPercent(priceAll, priceAllNow)) + String.format("%.2f", priceAllNow - priceAll));

        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        colBuyPrice.setCellValueFactory(new PropertyValueFactory<>("priceBuy"));
        colPriceNow.setCellValueFactory(new PropertyValueFactory<>("priceNow"));
        colPercent.setCellValueFactory(new PropertyValueFactory<>("percent"));

        tableView.setItems(list);
    }

    public void goBack() throws Exception{
        Stage thisStage = (Stage) imageBack.getScene().getWindow();
        thisStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void getSelected() throws Exception{
        int item = tableView.getSelectionModel().getSelectedIndex();
        System.out.println(Dop.getTag(Dop.getRow(item)));
    }
}
