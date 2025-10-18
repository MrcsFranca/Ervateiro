package com.erva.DAO;

import com.erva.model.Funcionario;
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
    public void atualizarMotorista(Motorista motorista) throws SQLException {
        open();
        this.sql = "UPDATE Motorista SET nome = ?, caminhao = ?, equipe = ? WHERE codMotorista = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, motorista.getNome());
        this.preparedStatement.setString(2, motorista.getCaminhao());
        this.preparedStatement.setBoolean(3, motorista.getEquipeColeta());
        this.preparedStatement.setString(4, motorista.getCodMotorista());
        this.preparedStatement.executeUpdate();
        close();
    }
    public void removerMotorista(Motorista motorista) throws SQLException {
        open();
        this.sql = "DELETE FROM motorista WHERE codMotorista = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, motorista.getCodMotorista());
        this.preparedStatement.executeUpdate();
        close();
    }
    public ArrayList<Motorista> listarTodosMotorista() throws SQLException {
        ArrayList<Motorista> motoristas = new ArrayList<>();
        open();
        this.sql = "SELECT * FROM motorista";
        this.preparedStatement = this.connection.prepareStatement(this.sql);
        this.resultSet = this.preparedStatement.executeQuery();
        while(this.resultSet.next()){
            Motorista motoristaAux = new Motorista(this.resultSet.getString("codMotorista"));
            motoristaAux.setNome(this.resultSet.getString("nome"));
            motoristaAux.setCaminhao(this.resultSet.getString("caminhao"));
            motoristaAux.setEquipeColeta(this.resultSet.getBoolean("equipeColeta"));
            motoristas.add(motoristaAux);
        }
        close();
        return motoristas;
    }

    public Motorista buscaMotorista(Motorista motorista) throws SQLException {
        open();
        this.sql = "SELECT * FROM Motorista WHERE codMotorista = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, motorista.getCodMotorista());
        this.resultSet = this.preparedStatement.executeQuery();
        Motorista motoristaAux = null;
        if(this.resultSet.next()) {
            motoristaAux = new Motorista(this.resultSet.getString("codMotorista"));
            motoristaAux.setNome(this.resultSet.getString("nome"));
            motoristaAux.setCaminhao(this.resultSet.getString("caminhao"));
            motoristaAux.setEquipeColeta(this.resultSet.getBoolean("equipe"));
        }
        close();
        return motoristaAux;
    }
}
