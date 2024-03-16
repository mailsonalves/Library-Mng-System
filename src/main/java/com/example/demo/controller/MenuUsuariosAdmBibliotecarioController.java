package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.model.Livro;
import com.example.demo.model.LivroDAOImpl;
import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioDAOImpl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuUsuariosAdmBibliotecarioController {

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
    private RadioButton admFilter;

    @FXML
    private RadioButton bibliotecarioFilter;

    @FXML
    private RadioButton leitorFilter;

    @FXML
    private TextField labelSearch;

    @FXML
    private Button btnCadastrarUsuario;


    @FXML
    void btnSairOnAction(ActionEvent event) throws IOException {
        HelloApplication.trocaDeTela("login-view.fxml", null);
    }
    @FXML
    void initialize() {


        leitorFilter.setOnAction(e -> {
            bibliotecarioFilter.setSelected(false);
            admFilter.setSelected(false);
            leitorFilter.setSelected(true);


        });
        bibliotecarioFilter.setOnAction(e -> {
            admFilter.setSelected(false);
            leitorFilter.setSelected(false);
            bibliotecarioFilter.setSelected(true);

        });
        admFilter.setOnAction(e -> {
            leitorFilter.setSelected(false);
            bibliotecarioFilter.setSelected(false);
            admFilter.setSelected(true);

        });


        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

        List list = painelPesquisa.getChildrenUnmodifiable();

        //Colocando hover dos icones da barra lateral
        iconUsers.setOnMouseEntered(e -> {
            btnUsuarios.setStyle("-fx-background-color:#D9D9D9;");
        });
        iconUsers.setOnMouseClicked(e -> {
            try {
                HelloApplication.trocaDeTela("menu-usuario-view-adm-bibliotecario.fxml", null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
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
        iconbook.setOnMouseClicked(e -> {
            try {
                HelloApplication.trocaDeTela("menu-livros-view-adm-bibliotecario.fxml", null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        labelSearch.setOnAction(e -> {
                   if(!(leitorFilter.isSelected()) && !(admFilter.isSelected()) && !(bibliotecarioFilter.isSelected())){
                        leitorFilter.setSelected(true);
                   }
                    if (leitorFilter.isSelected()) {
                        List<Usuario> usuarios = usuarioDAO.pesquisarUsuariosLeitor(labelSearch.getText());
                        tela.getChildren().clear();
                        renderizarListagem(usuarios);
                    } else if (bibliotecarioFilter.isSelected()) {
                        List<Usuario> usuarios = usuarioDAO.pesquisarUsuariosBibliotecario(labelSearch.getText());
                        tela.getChildren().clear();
                        renderizarListagem(usuarios);
                    }
                    else if (admFilter.isSelected()) {
                        List<Usuario> usuarios = usuarioDAO.pesquisarUsuariosADM(labelSearch.getText());
                        tela.getChildren().clear();
                        renderizarListagem(usuarios);
                    }


                    else {
                        List<Usuario> usuarios = usuarioDAO.pesquisarUsuarios();
                        tela.getChildren().clear();
                        renderizarListagem(usuarios);
                    }
                }     );




        List<Usuario> usuarios = usuarioDAO.pesquisarUsuarios();
        tela.getChildren().clear();
        renderizarListagem(usuarios);

        btnCadastrarUsuario.setOnAction(e -> {
            try {
                HelloApplication.trocaDeTela("cadastro-usuario-view.fxml", null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'menu-livros-view-adm-bibliotecario.fxml'.";

    }

    private void renderizarListagem(List<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            AnchorPane result = new AnchorPane();
            result.setPrefSize(680, 70);
            result.setStyle("-fx-background-color: #D9D9D9;");
            result.setLayoutY(90 * i);
            result.setLayoutX(10);
            result.setCursor(javafx.scene.Cursor.HAND);
            int finalI = i;
            result.setOnMouseClicked(e2-> {
                try {
                    UsuarioController controller = new UsuarioController(usuarios.get(finalI));
                    HelloApplication.trocaDeTela("usuario-view.fxml",controller);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            result.setOnMouseEntered(e2 -> {
                result.setStyle("-fx-background-color: #78F1CD;");
            });
            result.setOnMouseExited(e2 -> {
                result.setStyle("-fx-background-color: #D9D9D9;");
            });
            Label label = new Label();
            result.getChildren().add(label);
            label.setLayoutX(60);
            label.setLayoutY(10);
            label.setText(usuarios.get(i).getNome());
            label.setFont(new javafx.scene.text.Font("Helvetica Bold", 20));
            label.setStyle("-fx-text-fill: #000000;");
            Label label2 = new Label();
            result.getChildren().add(label2);
            label2.setLayoutX(60);
            label2.setLayoutY(40);
            label2.setText(usuarios.get(i).getCargo());
            label2.setFont(new javafx.scene.text.Font("System Bold", 15));
            FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.USER, "40");
            result.getChildren().add(icon);
            icon.setLayoutX(15);
            icon.setLayoutY(50);

            tela.getChildren().add(result);
            tela.setPrefHeight(100 * i);
        }
    }

}
