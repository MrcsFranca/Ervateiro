package com.erva.controller;

import com.erva.DAO.EntregaDAOJDBC;
import com.erva.DAO.FornecedorDAOJDBC;
import com.erva.DAO.FuncionarioDAOJDBC;
import com.erva.DAO.MotoristaDAOJDBC;
import com.erva.model.Entrega;
import com.erva.model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TabelaEntregasController {

    @FXML private TableView<Entrega> tabelaEntregas;

    @FXML private TableColumn<Entrega, Integer> colId;
    @FXML private TableColumn<Entrega, String> colFuncionario;
    @FXML private TableColumn<Entrega, String> colMotorista;
    @FXML private TableColumn<Entrega, String> colFornecedor;
    @FXML private TableColumn<Entrega, String> colTipoErva;
    @FXML private TableColumn<Entrega, Double> colPeso;
    @FXML private TableColumn<Entrega, String> colDesc;
    @FXML private TableColumn<Entrega, LocalDateTime> colDataHora;

    @FXML
    public void initialize() throws SQLException {
        FuncionarioDAOJDBC funcionarioDAO = new FuncionarioDAOJDBC();
        MotoristaDAOJDBC motoristaDAO = new MotoristaDAOJDBC();
        FornecedorDAOJDBC  fornecedorDAO = new FornecedorDAOJDBC();
        colId.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getEntregaId()));
        colFuncionario.setCellValueFactory(cell -> {
            try {
                return new SimpleStringProperty(funcionarioDAO.buscaFuncionario(cell.getValue().getFuncionario()).getNome());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        colMotorista.setCellValueFactory(cell -> {
            try {
                return new SimpleStringProperty(motoristaDAO.buscaMotorista(cell.getValue().getMotorista()).getNome());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        colFornecedor.setCellValueFactory(cell -> {
            try {
                return new SimpleStringProperty(fornecedorDAO.buscaFornecedor(cell.getValue().getFornecedor()).getNome());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        colTipoErva.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTipoErva()));
        colPeso.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getPeso()));
        colDesc.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescricao()));
        colDataHora.setCellValueFactory(cell -> new SimpleObjectProperty<LocalDateTime>(cell.getValue().getDataHora().toLocalDateTime()));

        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();

        ArrayList<Entrega> entregas = entregaDAOJDBC.listaTodosEntregas();
        ObservableList<Entrega> observable = FXCollections.observableArrayList(entregas);
        tabelaEntregas.setItems(observable);
    }
}
