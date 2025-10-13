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

    public void inserirMotorista(Motorista motorista){}
    public void atualizarMotorista(Motorista motorista){}
    public void removerMotorista(Motorista motorista){}
    public ArrayList<Motorista> listarTodosMotorista(){}
}
