package com.erva.controller;
import com.erva.DAO.MotoristaDAOJDBC;
import com.erva.model.Motorista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastrarMotoristaController {

    @FXML
    private Button btnCadastrarMotorista;

    @FXML
    private Button btnCadastros;

    @FXML
    private Button btnEntregas;

    @FXML
    private TextField textFieldCaminhao;

    @FXML
    private TextField textFieldCpfCnpj;

    @FXML
    private CheckBox checkBoxEquipeColeta;

    @FXML
    private TextField textFieldNome;

    @FXML
    public void acessarCadastros(javafx.event.ActionEvent actionEvent) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/erva/ervateiro/Cadastros.fxml"));
            Parent telaRegistros = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Cadastros");
            stage.setScene(new Scene(telaRegistros));
            stage.setMaximized(false);
            stage.setResizable(false);
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
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cadastrarMotorista(javafx.event.ActionEvent actionEvent) throws SQLException {
        MotoristaDAOJDBC motoristaDAO = new MotoristaDAOJDBC();
        Motorista motorista = new Motorista(textFieldCpfCnpj.getText());

        motorista.setCaminhao(textFieldCaminhao.getText());
        motorista.setNome(textFieldNome.getText());
        if(checkBoxEquipeColeta.isSelected()) {
            motorista.setEquipeColeta(true);
        } else {
            motorista.setEquipeColeta(false);
        }
        motoristaDAO.inserirMotorista(motorista);
        new Alert(Alert.AlertType.CONFIRMATION, "Motorista registrado com sucesso.", ButtonType.OK).showAndWait();
    }

}
