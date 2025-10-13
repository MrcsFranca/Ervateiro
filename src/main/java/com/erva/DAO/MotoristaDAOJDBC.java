package com.erva.DAO;

import com.erva.model.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotoristaDAOJDBC {
    private String sql;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    private void open() throws SQLException {
        this.connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
    }

    private void close() throws SQLException {
        this.connection.close();
    }

    public void inserirMotorista(Motorista motorista) throws SQLException {
        open();
        this.sql = "INSERT INTO motorista (codMotorista, nome, caminhao, equipe) VALUES (?, ?, ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, motorista.getCodMotorista());
        this.preparedStatement.setString(2, motorista.getNome());
        this.preparedStatement.setString(3, motorista.getCaminhao());
        this.preparedStatement.setBoolean(4, motorista.getEquipeColeta());
        this.preparedStatement.executeUpdate();
        close();
    }
    public void atualizarMotorista(Motorista motorista){}
    public void removerMotorista(Motorista motorista){}
    public ArrayList<Motorista> listarTodosMotorista(){}
}
