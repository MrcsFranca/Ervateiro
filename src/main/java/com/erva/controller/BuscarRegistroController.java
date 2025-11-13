package com.erva.controller;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import com.erva.model.Entrega;
import com.erva.DAO.EntregaDAO;
import com.erva.DAO.EntregaDAOJDBC;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class BuscarRegistroController {

    @FXML
    private RadioButton CultivadaRadioBtn;

    @FXML
    private DatePicker FiltroDatePicker;

    @FXML
    private RadioButton MistaRadioBtn;

    @FXML
    private RadioButton NativaRadioBtn;

    @FXML
    private TextField PesquisarFornecedorTextField;

    @FXML
    private TextField PesquisarMotoristaTextField;

    @FXML
    private TextField pesoMaxTextField;

    @FXML
    private TextField pesoMinTextField;

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
    void buscar(ActionEvent event) throws SQLException, IOException {
        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();
        String nomeFornecedor = PesquisarFornecedorTextField.getText();
        String nomeMotorista = PesquisarMotoristaTextField.getText();
        LocalDate dataInicio = FiltroDatePicker.getValue();
        LocalDate dataFim = FiltroDatePicker.getValue();
        Timestamp dataEntregaInicio = null;
        Timestamp dataEntregaFinal = null;
        if (dataInicio != null) {
            dataEntregaInicio = Timestamp.valueOf(LocalDateTime.of(dataInicio, LocalTime.MIN));
        }
        if (dataFim != null) {
            dataEntregaFinal = Timestamp.valueOf(LocalDateTime.of(dataFim, LocalTime.of(23, 59, 59)));
        }
        String tipoEntrega = null;
        if (NativaRadioBtn.isSelected()) {
             tipoEntrega = "nativa";
        }
        else if (CultivadaRadioBtn.isSelected()) {
             tipoEntrega = "plantada";
        }
        else if(MistaRadioBtn.isSelected()){
             tipoEntrega = "mista";
        }
        Double pesoMin = pesoMinTextField.getText().isEmpty() ? 0.0 : Double.parseDouble(pesoMinTextField.getText());
        Double pesoMax = pesoMaxTextField.getText().isEmpty() ? Double.MAX_VALUE : Double.parseDouble(pesoMaxTextField.getText());

        ArrayList<Entrega>entregas = entregaDAOJDBC.buscarEntregas(nomeMotorista, nomeFornecedor, dataEntregaInicio, dataEntregaFinal, pesoMin, pesoMax, tipoEntrega);
        for(Entrega entrega : entregas){
            System.out.println(entrega);
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/erva/ervateiro/TabelaBusca.fxml"));
        Parent root = loader.load();

        TabelaBuscaController controller = loader.getController();
        controller.carregarEntregas(entregas);

        Stage stage = new Stage();
        stage.setTitle("Lista de Entregas");
        stage.setScene(new Scene(root));
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }
}
