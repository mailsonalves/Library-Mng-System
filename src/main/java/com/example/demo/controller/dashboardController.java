package com.example.demo.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
public class dashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEntrar;


    @FXML
    private ScrollPane painelPesquisa;

    @FXML
    private AnchorPane result;


    @FXML
    private Pane tela;

    @FXML
    void BtnntrarOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {

        List list = painelPesquisa.getChildrenUnmodifiable();
        System.out.println(list);


        for (int i = 0; i < 10; i++) {
            AnchorPane result = new AnchorPane();
            result.setPrefSize(680, 70);

            result.setStyle("-fx-background-color: #D9D9D9;");
            result.setLayoutY(90 * i);
            result.setLayoutX(10);
            result.setCursor(javafx.scene.Cursor.HAND);
            result.setOnMouseClicked(e -> {
                System.out.println("Clicou");
            });

            tela.getChildren().add(result);
            tela.setPrefHeight(100 * i);
        }
        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'dashboard.fxml'.";

    }

}
