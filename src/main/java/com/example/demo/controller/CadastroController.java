package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.Statement;
import com.example.demo.HelloApplication;
import com.example.demo.model.Conexao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

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
    private TextField inputEmail;

    @FXML
    private TextField inputNome;

    @FXML
    private PasswordField inputSenha1;

    @FXML
    private PasswordField inputSenha2;

    @FXML
    private TextField inputUsuario;

    @FXML
    private Label labelMsg;

    @FXML
    void BtnVoltarOnAction(ActionEvent event) throws IOException {
        HelloApplication.trocaDeTela("login-view.fxml");

    }

    @FXML
    void btnCadastar(ActionEvent event) {
        if (inputNome.getText().isEmpty() || inputUsuario.getText().isEmpty() || inputEmail.getText().isEmpty() || inputSenha1.getText().isEmpty() || inputSenha2.getText().isEmpty()) {
            labelMsg.setText("Preencha todos os campos!");
            return;
        }
        if (!inputSenha1.getText().equals(inputSenha2.getText())) {
            labelMsg.setText("As senhas não coincidem!");
            return;
        }
        realizarCadastro();

    }

    private void realizarCadastro() {
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.getConnection();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO usuarios (nome, usuario, email, senha) VALUES ('" + inputNome.getText() + "', '" + inputUsuario.getText() + "', '" + inputEmail.getText() + "', '" + inputSenha1.getText() + "')";
            stmt.executeUpdate(sql);
            labelMsg.setText("Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            labelMsg.setText("Erro ao realizar cadastro!");
            e.printStackTrace();
    }

}

    @FXML
    void initialize() {
        assert btnCadastar != null : "fx:id=\"btnCadastar\" was not injected: check your FXML file 'cadastro-view.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'cadastro-view.fxml'.";

    }

}
