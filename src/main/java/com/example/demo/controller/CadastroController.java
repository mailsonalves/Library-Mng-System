package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CadastroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastar;

    @FXML
    private Button btnVoltar;


    @FXML
    void BtnVoltarOnAction(ActionEvent event) throws IOException {
        HelloApplication.trocaDeTela("login-view.fxml");

    }

    @FXML
    void btnCadastar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCadastar != null : "fx:id=\"btnCadastar\" was not injected: check your FXML file 'cadastro-view.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'cadastro-view.fxml'.";

    }

}
