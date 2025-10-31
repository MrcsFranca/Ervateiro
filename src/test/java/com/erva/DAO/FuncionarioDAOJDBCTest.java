package com.erva.DAO;

import com.erva.model.Funcionario;
import com.erva.model.Motorista;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioDAOJDBCTest {

    @Test
    void inserirFuncionario() throws SQLException {
        FuncionarioDAOJDBC funcionarioDAOJDBC = new FuncionarioDAOJDBC();
        Funcionario  funcionario = new Funcionario("07050680990");
        funcionario.setNumCt("123456789");
        funcionario.setCelular("40028922");
        funcionario.setNome("FuncTeste");
        funcionarioDAOJDBC.removerFuncionario(funcionario);
        assertDoesNotThrow(() -> {
            funcionarioDAOJDBC.inserirFuncionario(funcionario);
        }, "Erro ao inserir funcionario, excecao de sql lançada");
    }

    @Test
    void buscarFuncionario() throws SQLException {
        FuncionarioDAOJDBC funcionarioDAOJDBC = new FuncionarioDAOJDBC();
        Funcionario funcionario = new Funcionario("07050680990");
        funcionario.setNumCt("123456789");
        funcionario.setCelular("40028922");
        funcionario.setNome("FuncTeste");
        assertDoesNotThrow(() -> {
            funcionarioDAOJDBC.buscaFuncionario(funcionario);
        },  "Erro ao buscar funcionario, excecao de sql lançada");
    }
}