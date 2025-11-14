package com.erva.controller;

import com.erva.DAO.FornecedorDAOJDBC;
import com.erva.model.Fornecedor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastrarFornecedorController {

    @FXML
    private Button btnCadastrarFornecedor;

    @FXML
    private Button btnCadastros;

    @FXML
    private Button btnEntregas;

    @FXML
    private TextField textFieldCpfCnpj;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private TextField textFieldNome;

    @FXML
    private RadioButton radioButtonPessoaFisica;

    @FXML
    private RadioButton radioButtonPessoaJuridica;

    @FXML
    private ToggleGroup tipoFornecedorGroup;

    @FXML
    public void initialize() {
        tipoFornecedorGroup =  new ToggleGroup();
        radioButtonPessoaFisica.setToggleGroup(tipoFornecedorGroup);
        radioButtonPessoaJuridica.setToggleGroup(tipoFornecedorGroup);
    }


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
    void cadastrarFornecedor(javafx.event.ActionEvent actionEvent) throws SQLException {
        FornecedorDAOJDBC fornecedorDAO = new FornecedorDAOJDBC();
        Fornecedor fornecedor = new Fornecedor();

        if(radioButtonPessoaJuridica.isSelected()) {
            fornecedor.setCnpj(textFieldCpfCnpj.getText());
            fornecedor.setFornecedorFisico(false);
        } else if(radioButtonPessoaFisica.isSelected()) {
            fornecedor.setCpf(textFieldCpfCnpj.getText());
            fornecedor.setFornecedorFisico(true);
        }
        fornecedor.setEndereco(textFieldEndereco.getText());
        fornecedor.setNome(textFieldNome.getText());

        fornecedorDAO.inserirFornecedor(fornecedor);
        new Alert(Alert.AlertType.CONFIRMATION, "Fornecedor registrado com sucesso.", ButtonType.OK).showAndWait();
    }

}
