package com.erva.DAO;
import com.erva.model.Funcionario;
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

    public void inserirFuncionario(Funcionario funcionario){}
    public void atualizarFuncionario(Funcionario funcionario){}
    public void removerFuncionario(Funcionario funcionario){}
    public ArrayList<Funcionario> listarTodosFuncionario(){}
}
