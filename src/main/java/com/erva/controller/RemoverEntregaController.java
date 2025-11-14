//Parte da refatoração: Adicionar refresh na tela de remover entrega para atualizar os ids disponíveis para remoção.

package com.erva.controller;

import com.erva.DAO.EntregaDAOJDBC;
import com.erva.model.Entrega;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class RemoverEntregaController {
    @FXML
    private Button btnCadastros;

    @FXML
    private Button btnEntregas;

    @FXML
    private ComboBox<Integer> comboBoxId;

    @FXML
    void initialize() {
        try{
            mostrarId();
        }
        catch(SQLException e){
            e.printStackTrace();
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
    void removerEntrega(javafx.event.ActionEvent actionEvent) throws SQLException {
        EntregaDAOJDBC  entregaDAOJDBC = new EntregaDAOJDBC();
        Entrega entregaAux = new Entrega();
        entregaAux.setEntregaId(comboBoxId.getValue());
        entregaDAOJDBC.removerEntrega(entregaAux);
        initialize();
        new Alert(Alert.AlertType.CONFIRMATION, "Entrega removida com sucesso.", ButtonType.OK).showAndWait();
    }

}
