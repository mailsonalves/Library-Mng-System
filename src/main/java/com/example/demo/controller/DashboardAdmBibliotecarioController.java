package com.example.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.demo.HelloApplication;
import com.example.demo.model.Livro;
import com.example.demo.model.LivroDAOImpl;
import com.example.demo.model.Usuario;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

public class DashboardAdmBibliotecarioController {

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
    private RadioButton tituloFilter;

    @FXML
    private RadioButton autorFilter;

    @FXML
    private RadioButton categoriaFilter;

    @FXML
    private RadioButton isbnFilter;

    @FXML
    private TextField labelSearch;

    @FXML
    private Button btnCadastrarLivro;


    @FXML
    void btnSairOnAction(ActionEvent event) throws IOException {
        HelloApplication.trocaDeTela("login-view.fxml", null);
    }
    @FXML
    void initialize() {
        tituloFilter.setSelected(true);

        isbnFilter.setOnAction(e -> {
            autorFilter.setSelected(false);
            tituloFilter.setSelected(false);
            categoriaFilter.setSelected(false);
            isbnFilter.setSelected(true);
        });
        categoriaFilter.setOnAction(e -> {
            autorFilter.setSelected(false);
            tituloFilter.setSelected(false);
            categoriaFilter.setSelected(true);
            isbnFilter.setSelected(false);
        });
        tituloFilter.setOnAction(e -> {
            autorFilter.setSelected(false);
            tituloFilter.setSelected(true);
            categoriaFilter.setSelected(false);
            isbnFilter.setSelected(false);
        });
        autorFilter.setOnAction(e -> {
            autorFilter.setSelected(true);
            tituloFilter.setSelected(false);
            categoriaFilter.setSelected(false);
            isbnFilter.setSelected(false);
        });

        LivroDAOImpl livroDAO = new LivroDAOImpl();

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
                    if (tituloFilter.isSelected()) {
                        List<Livro> livros = livroDAO.pesquisarLivrosTitulo(labelSearch.getText());
                        tela.getChildren().clear();
                        renderizarListagem(livros);
                        }

                    else if (autorFilter.isSelected()) {
                        List<Livro> livros = livroDAO.pesquisarLivrosAutor(labelSearch.getText());
                        tela.getChildren().clear();
                        renderizarListagem(livros);
                    }
                    else if (categoriaFilter.isSelected()) {
                        List<Livro> livros = livroDAO.pesquisarLivrosCategoria(labelSearch.getText());
                        tela.getChildren().clear();
                        renderizarListagem(livros);
                    }
                    else if (isbnFilter.isSelected()) {
                        List<Livro> livros = livroDAO.pesquisarLivrosisbn (labelSearch.getText());
                        tela.getChildren().clear();
                        renderizarListagem(livros);
                    }
                    else {
                        List<Livro> livros = livroDAO.pesquisarLivros();
                        tela.getChildren().clear();
                        renderizarListagem(livros);
                    }
                }     );


        List<Livro> livros = livroDAO.pesquisarLivros();

        for (int i = 0; i < livros.size(); i++) {
            AnchorPane result = new AnchorPane();
            result.setPrefSize(680, 70);
            result.setStyle("-fx-background-color: #D9D9D9;");
            result.setLayoutY(90 * i);
            result.setLayoutX(10);
            result.setCursor(javafx.scene.Cursor.HAND);
            int finalI = i;
            result.setOnMouseClicked(e -> {
                try {
                    LivroController controller = new LivroController(livros.get(finalI));
                    HelloApplication.trocaDeTela("livro-view.fxml",controller);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
            label.setText(livros.get(i).getTitulo());
            label.setFont(new javafx.scene.text.Font("Helvetica Bold", 20));
            label.setStyle("-fx-text-fill: #000000;");
            Label label2 = new Label();
            result.getChildren().add(label2);
            label2.setLayoutX(60);
            label2.setLayoutY(40);
            label2.setText(livros.get(i).getAutor());
            label2.setFont(new javafx.scene.text.Font("System Bold", 15));
            FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.BOOK, "40");
            result.getChildren().add(icon);
            icon.setLayoutX(15);
            icon.setLayoutY(50);

            tela.getChildren().add(result);
            tela.setPrefHeight(100 * i);
        }
        btnCadastrarLivro.setOnAction(e -> {
            try {
                HelloApplication.trocaDeTela("cadastro-livro-view.fxml", null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        assert btnEntrar != null : "fx:id=\"btnEntrar\" was not injected: check your FXML file 'menu-livros-view-adm-bibliotecario.fxml'.";

    }
    private void renderizarListagem(List<Livro> livros) {
        for (int i = 0; i < livros.size(); i++) {
            AnchorPane result = new AnchorPane();
            result.setPrefSize(680, 70);
            result.setStyle("-fx-background-color: #D9D9D9;");
            result.setLayoutY(90 * i);
            result.setLayoutX(10);
            result.setCursor(javafx.scene.Cursor.HAND);
            int finalI = i;
            result.setOnMouseClicked(e2 -> {
                try {
                    LivroController controller = new LivroController(livros.get(finalI));
                    HelloApplication.trocaDeTela("livro-view.fxml",controller);
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
            label.setText(livros.get(i).getTitulo());
            label.setFont(new javafx.scene.text.Font("Helvetica Bold", 20));
            label.setStyle("-fx-text-fill: #000000;");
            Label label2 = new Label();
            result.getChildren().add(label2);
            label2.setLayoutX(60);
            label2.setLayoutY(40);
            label2.setText(livros.get(i).getAutor());
            label2.setFont(new javafx.scene.text.Font("System Bold", 15));
            FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.BOOK, "40");
            result.getChildren().add(icon);
            icon.setLayoutX(15);
            icon.setLayoutY(50);

            tela.getChildren().add(result);
            tela.setPrefHeight(100 * i);
        }
    }

}
