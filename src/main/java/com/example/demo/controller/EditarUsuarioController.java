package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.model.Usuario;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private FontAwesomeIconView iconUsers;

    @FXML
    private FontAwesomeIconView iconbook;

    @FXML
    private TextField inputBairro;

    @FXML
    private TextField inputCPF;

    @FXML
    private TextField inputCidade;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputEndereco;

    @FXML
    private TextField inputEstado;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputTelefone;

    @FXML
    private TextField inputUsuario;

    @FXML
    private Label labelAviso;

    @FXML
    private ChoiceBox<?> labelCargo;

    private Usuario usuario;
    public EditarUsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    @FXML
    void btnCadastrarOnAction(ActionEvent event) {

    }

    @FXML
    void btnSairOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCadastrar != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert btnSair != null : "fx:id=\"btnSair\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert btnUsuarios != null : "fx:id=\"btnUsuarios\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert iconUsers != null : "fx:id=\"iconUsers\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert iconbook != null : "fx:id=\"iconbook\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputBairro != null : "fx:id=\"inputBairro\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputCPF != null : "fx:id=\"inputCPF\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputCidade != null : "fx:id=\"inputCidade\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputEmail != null : "fx:id=\"inputEmail\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputEndereco != null : "fx:id=\"inputEndereco\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputEstado != null : "fx:id=\"inputEstado\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputNome != null : "fx:id=\"inputNome\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputTelefone != null : "fx:id=\"inputTelefone\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert inputUsuario != null : "fx:id=\"inputUsuario\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert labelAviso != null : "fx:id=\"labelAviso\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";
        assert labelCargo != null : "fx:id=\"labelCargo\" was not injected: check your FXML file 'editar-usuario-view.fxml'.";

    }

}
