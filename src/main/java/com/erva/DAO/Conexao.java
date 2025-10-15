package com.erva.DAO;
import java.sql.*;

public class Conexao implements IConst {
    public static Connection getConexao(String stringDeConexao, String usuario, String senha) {
        try{
            return DriverManager.getConnection(stringDeConexao, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
}
