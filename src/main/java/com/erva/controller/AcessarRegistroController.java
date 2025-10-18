package com.erva.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class AcessarRegistroController {
    @FXML
    private Button btnMostrarRegistro;

    @FXML
    public void mostrarRegistro(ActionEvent event) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/erva/ervateiro/TabelaEntregas.fxml"));
            Parent telaRegistros = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Registros de Entrega");
            stage.setScene(new Scene(telaRegistros));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
