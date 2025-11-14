package com.erva.controller;
import com.erva.DAO.FuncionarioDAOJDBC;
import com.erva.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastrarFuncionarioController {

    @FXML
    private Button btnCadastrarFuncionario;

    @FXML
    private Button btnCadastros;

    @FXML
    private Button btnEntregas;

    @FXML
    private TextField textFieldCarteiraTrabalho;

    @FXML
    private TextField textFieldCpf;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldTelefone;

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
    void cadastrarFuncionario(javafx.event.ActionEvent actionEvent) throws SQLException {
        FuncionarioDAOJDBC funcionarioDAO = new FuncionarioDAOJDBC();
        Funcionario funcionario = new Funcionario(textFieldCpf.getText());

        funcionario.setNome(textFieldNome.getText());
        funcionario.setNumCt(textFieldCarteiraTrabalho.getText());
        funcionario.setCelular(textFieldTelefone.getText());

        funcionarioDAO.inserirFuncionario(funcionario);
        new Alert(Alert.AlertType.CONFIRMATION, "Funcionario registrado com sucesso.", ButtonType.OK).showAndWait();
    }

}
