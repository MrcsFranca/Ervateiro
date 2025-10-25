package com.erva.controller;

import com.erva.DAO.EntregaDAOJDBC;
import com.erva.DAO.FornecedorDAOJDBC;
import com.erva.DAO.FuncionarioDAOJDBC;
import com.erva.DAO.MotoristaDAOJDBC;
import com.erva.model.Entrega;
import com.erva.model.Fornecedor;
import com.erva.model.Funcionario;
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
import java.util.ArrayList;

public class AtualizarRegistroController {
    @FXML
    private Button btnEntrega;

    @FXML
    private ComboBox<Fornecedor> comboBoxFornecedor;

    @FXML
    private ComboBox<Motorista> comboBoxMotorista;

    @FXML
    private RadioButton radioBtnCultivada;

    @FXML
    private RadioButton radioBtnMista;

    @FXML
    private RadioButton radioBtnNativa;

    @FXML
    private TextArea textFieldDescricao;

    @FXML
    private TextField textFieldPeso;

    @FXML
    private ComboBox<Integer> comboBoxId;

    @FXML
    private ComboBox<Funcionario> comboBoxFuncionario;
    @FXML
    public void initialize() {
        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();
        try {
            mostrarFuncionarios();
            mostrarFornecedor();
            mostrarMotorista();
            mostrarId();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    @FXML
    void mostrarFuncionarios() throws SQLException{
        FuncionarioDAOJDBC funcionarioDAO = new FuncionarioDAOJDBC();
        ArrayList<Funcionario> funcionarios = funcionarioDAO.listarTodosFuncionario();
        comboBoxFuncionario.getItems().clear();
        for(Funcionario funcionario : funcionarios){
            comboBoxFuncionario.getItems().addAll(funcionario);
        }
    }

    @FXML
    void mostrarMotorista() throws SQLException{
        MotoristaDAOJDBC MotoristaDAO = new MotoristaDAOJDBC();
        ArrayList<Motorista> motoristas = MotoristaDAO.listarTodosMotorista();
        comboBoxMotorista.getItems().clear();
        for(Motorista motorista : motoristas){
            comboBoxMotorista.getItems().addAll(motorista);
        }
    }

    @FXML
    void mostrarId() throws SQLException{
        EntregaDAOJDBC entregaDAO = new EntregaDAOJDBC();
        ArrayList<Entrega> entregas = entregaDAO.listaTodosEntregas();
        comboBoxId.getItems().clear();
        for(Entrega entrega : entregas){
            comboBoxId.getItems().add(entrega.getEntregaId());
        }
    }


    @FXML
    void mostrarFornecedor() throws SQLException{
        FornecedorDAOJDBC fornecedorDAO = new FornecedorDAOJDBC();
        ArrayList<Fornecedor> fornecedores = fornecedorDAO.listarTodosFornecedor();
        comboBoxFornecedor.getItems().clear();
        for(Fornecedor fornecedor : fornecedores){
            comboBoxFornecedor.getItems().addAll(fornecedor);
        }
    }

    @FXML
    void atualizarEntrega(ActionEvent event) throws SQLException {
        EntregaDAOJDBC entregaDAO = new EntregaDAOJDBC();
        Entrega entregaAux = new Entrega();
        entregaAux.setEntregaId(comboBoxId.getValue());
        entregaAux.setDescricao(textFieldDescricao.getText());
        entregaAux.setPeso(Double.parseDouble(textFieldPeso.getText()));
        entregaAux.setFornecedor(comboBoxFornecedor.getValue());
        entregaAux.setMotorista(comboBoxMotorista.getValue());
        entregaAux.setFuncionario(comboBoxFuncionario.getValue());
        if (radioBtnCultivada.isSelected()) {
            entregaAux.setTipoErva("plantada");
        }
        else if (radioBtnNativa.isSelected())
        {
            entregaAux.setTipoErva("nativa");
        }
        else
        {
            entregaAux.setTipoErva("misturada");
        }
        entregaDAO.atualizaEntrega(entregaAux);
        new Alert(Alert.AlertType.CONFIRMATION, "Entrega atualizada com sucesso.", ButtonType.OK).showAndWait();

    }

}
