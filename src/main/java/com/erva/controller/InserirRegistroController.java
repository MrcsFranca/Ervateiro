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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InserirRegistroController{

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
    private ComboBox<Funcionario> comboBoxFuncionario;

    public void initialize() {
        try {
            mostrarFuncionarios();
            mostrarFornecedor();
            mostrarMotorista();
        } catch (SQLException e) {
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
    void mostrarFornecedor() throws SQLException{
        FornecedorDAOJDBC fornecedorDAO = new FornecedorDAOJDBC();
        ArrayList<Fornecedor> fornecedores = fornecedorDAO.listarTodosFornecedor();
        comboBoxFornecedor.getItems().clear();
        for(Fornecedor fornecedor : fornecedores){
            comboBoxFornecedor.getItems().addAll(fornecedor);
        }
    }

    @FXML
    void cadastrarEntrega(ActionEvent event) throws SQLException {
        EntregaDAOJDBC entregaDAO = new EntregaDAOJDBC();
        Entrega entregaAux = new Entrega();
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
        entregaDAO.insereEntrega(entregaAux);
    }


}
