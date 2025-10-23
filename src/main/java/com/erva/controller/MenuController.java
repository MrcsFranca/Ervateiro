package com.erva.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MenuController {

    @FXML
    private Button btnCadastros;

    @FXML
    private Button btnEntregas;

    @FXML
    public void acessarCadastros(javafx.event.ActionEvent actionEvent) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/erva/ervateiro/Cadastros.fxml"));
            Parent telaRegistros = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Cadastros");
            stage.setScene(new Scene(telaRegistros));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void acessarEntregas(javafx.event.ActionEvent actionEvent) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/erva/ervateiro/Entregas.fxml"));
            Parent telaRegistros = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Entregas");
            stage.setScene(new Scene(telaRegistros));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
