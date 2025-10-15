package com.erva.DAO;
import com.erva.model.Funcionario;
import com.erva.model.Motorista;

import java.util.ArrayList;
import java.sql.*;
public class FuncionarioDAOJDBC implements FuncionarioDAO {
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

    public void inserirFuncionario(Funcionario funcionario) throws SQLException {
        open();
        this.sql = "INSERT INTO funcionario (cpf, nome, numCT, celular) VALUES (?, ?, ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, funcionario.getCpf());
        this.preparedStatement.setString(2, funcionario.getNome());
        this.preparedStatement.setString(3, funcionario.getNumCt());
        this.preparedStatement.setString(4, funcionario.getCelular());
        this.preparedStatement.executeUpdate();
        close();
    }
    public void atualizarFuncionario(Funcionario funcionario) throws SQLException {
        open();
        this.sql = "UPDATE Funcionario SET nome = ?, numCT = ?, celular = ? WHERE cpf = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, funcionario.getNome());
        this.preparedStatement.setString(2, funcionario.getNumCt());
        this.preparedStatement.setString(3, funcionario.getCelular());
        this.preparedStatement.setString(4, funcionario.getCpf());
        this.preparedStatement.executeUpdate();
        close();
    }
    public void removerFuncionario(Funcionario funcionario) throws SQLException {
        open();
        this.sql = "DELETE FROM funcionario WHERE cpf = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, funcionario.getCpf());
        this.preparedStatement.executeUpdate();
        close();
    }
    public ArrayList<Funcionario> listarTodosFuncionario() throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        open();
        this.sql = "SELECT * FROM funcionario";
        this.preparedStatement = this.connection.prepareStatement(this.sql);
        this.resultSet = this.preparedStatement.executeQuery();
        while (this.resultSet.next()) {
            Funcionario funcionarioAux = new Funcionario(this.resultSet.getString("cpf"));
            funcionarioAux.setNome(this.resultSet.getString("nome"));
            funcionarioAux.setNumCt(this.resultSet.getString("numCT"));
            funcionarioAux.setCelular(this.resultSet.getString("celular"));
            funcionarios.add(funcionarioAux);
        }
        close();
        return funcionarios;
    }

    public Funcionario buscaFuncionario(Funcionario funcionario) throws SQLException {
        open();
        this.sql = "SELECT * FROM Funcionario WHERE cpf = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, funcionario.getCpf());
        this.resultSet = this.preparedStatement.executeQuery();
        Funcionario funcionarioAux = new Funcionario(this.resultSet.getString("cpf"));
        funcionarioAux.setNome(this.resultSet.getString("nome"));
        funcionarioAux.setNumCt(this.resultSet.getString("numCT"));
        funcionarioAux.setCelular(this.resultSet.getString("celular"));
        close();
        return funcionarioAux;
    }
}
