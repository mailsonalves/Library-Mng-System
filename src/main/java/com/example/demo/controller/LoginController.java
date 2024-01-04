package com.example.demo.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.example.demo.model.Conexao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastar;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnRecuperarSenha;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private TextField inputUsuario;

    @FXML
    private Label labelMsg;

    @FXML
    void BtnntrarOnAction(ActionEvent event) {
        if (inputUsuario.getText().isEmpty() || inputSenha.getText().isEmpty()) {
            labelMsg.setText("Preencha todos os campos!");
            return;
        }
        validarLogin();

    }

    private void validarLogin(){
        Conexao conexao = new Conexao();
        Connection connection = conexao.getConnection();
        if (connection != null) {
            String verifyLogin = "SELECT count(1) FROM usuarios WHERE usuario = '" + inputUsuario.getText() + "' AND senha = '"
                    + inputSenha.getText() + "'";
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);
                while (queryResult.next()) {
                    if (queryResult.getInt(1) == 1) {
                        labelMsg.setText("Login realizado com sucesso!");
                    } else {

                        labelMsg.setText("usuário ou senha incorretos!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }


        } else {
            labelMsg.setText("Erro ao conectar!");
        }
    }

    @FXML
    void btnCadastar(ActionEvent event) {

    }

    @FXML
    void btnRecuperarSenha(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCadastar != null : "fx:id=\"btnCadastar\" was not injected: check your FXML file 'login-view.fxml'.";
        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'login-view.fxml'.";
        assert btnRecuperarSenha != null : "fx:id=\"btnRecuperarSenha\" was not injected: check your FXML file 'login-view.fxml'.";

    }

}
