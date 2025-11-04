package com.erva.DAO;

import com.erva.model.Funcionario;
import com.erva.model.Motorista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioDAOJDBCTest {

    private Funcionario funcionario;
    private FuncionarioDAOJDBC dao;

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
    void inserirFuncionarioInvalido() throws SQLException {
        FuncionarioDAOJDBC funcionarioDAOJDBC = new FuncionarioDAOJDBC();
        Funcionario  funcionario = new Funcionario("070506391829038190280990");
        funcionario.setNumCt("123456789");
        funcionario.setCelular("40028922");
        funcionario.setNome("FuncTeste");
        funcionarioDAOJDBC.removerFuncionario(funcionario);
        assertThrows(org.postgresql.util.PSQLException.class, () -> {
            funcionarioDAOJDBC.inserirFuncionario(funcionario);
        }, "Erro ao inserir funcionario invalido, excecao de sql nao lançada");
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

    @BeforeEach
    void setUp() throws SQLException {
        dao = new FuncionarioDAOJDBC();
        funcionario = new Funcionario("40028922");
        funcionario.setNome("Nome Original");
        funcionario.setNumCt("8979546123");
        funcionario.setCelular("4000022558");
        dao.removerFuncionario(funcionario);

        dao.inserirFuncionario(funcionario);

        Funcionario ultimo = dao.listarTodosFuncionario()
                .stream()
                .reduce((primeiro, segundo) -> segundo)
                .orElse(null);

        assertNotNull(ultimo, "Deveria haver ao menos um funcionario inserido");
    }

    @Test
    void atualizarFuncionario() throws SQLException {
        funcionario.setNome("Nome Alterado");
        funcionario.setNumCt("1245789630");
        funcionario.setCelular("74158963");

        assertDoesNotThrow(() -> {
            dao.atualizarFuncionario(funcionario);
        });
    }

    @Test
    void atualizarFuncionarioInvalido() throws SQLException {
        funcionario.setNome("Nome Alterado");
        funcionario.setNumCt("124578963025525852");
        funcionario.setCelular("7415896313467845135468751354");

        assertDoesNotThrow(() -> {
            dao.atualizarFuncionario(funcionario);
        });
    }

}