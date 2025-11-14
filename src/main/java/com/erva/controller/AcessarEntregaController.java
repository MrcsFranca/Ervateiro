package com.erva.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AcessarEntregaController {
    @FXML
    private Button btnMostrarRegistro;

    @FXML
    public void mostrarRegistro(javafx.event.ActionEvent actionEvent) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/erva/ervateiro/TabelaEntregas.fxml"));
            Parent telaRegistros = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Registros de Entregas");
            stage.setScene(new Scene(telaRegistros));
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
