package com.example.demo.controller;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

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
    private FontAwesomeIconView iconbook;

    @FXML
    private Button btnUsuarios;

    @FXML
    private FontAwesomeIconView iconUsers;
    @FXML
    void initialize() {

        List list = painelPesquisa.getChildrenUnmodifiable();
        System.out.println(list);

        iconUsers.setOnMouseEntered(e -> {
            btnUsuarios.setStyle("-fx-background-color:#D9D9D9;");
        });
        iconUsers.setOnMouseExited(e -> {
            btnUsuarios.setStyle("-fx-background-color: none;");
        });
        btnUsuarios.setOnMouseEntered(e -> {
            btnUsuarios.setStyle("-fx-background-color:#D9D9D9;");
        });
        btnUsuarios.setOnMouseExited(e -> {
            btnUsuarios.setStyle("-fx-background-color: none;");
        });

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
            result.setOnMouseEntered(e -> {
                result.setStyle("-fx-background-color: #78F1CD;");
            });
            result.setOnMouseExited(e -> {
                result.setStyle("-fx-background-color: #D9D9D9;");
            });
            Label label = new Label();
            result.getChildren().add(label);
            label.setLayoutX(60);
            label.setLayoutY(10);
            label.setText("Memórias Póstumas de Brás Cubas");
            label.setFont(new javafx.scene.text.Font("Helvetica Bold", 20));
            label.setStyle("-fx-text-fill: #000000;");
            Label label2 = new Label();
            result.getChildren().add(label2);
            label2.setLayoutX(60);
            label2.setLayoutY(40);
            label2.setText("Machado de Assis");
            label2.setFont(new javafx.scene.text.Font("System Bold", 15));
            FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.BOOK, "40");
            result.getChildren().add(icon);
            icon.setLayoutX(15);
            icon.setLayoutY(50);

            tela.getChildren().add(result);
            tela.setPrefHeight(100 * i);
        }
        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'dashboard.fxml'.";

    }

}
