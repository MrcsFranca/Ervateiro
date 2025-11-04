package com.erva.DAO;

import com.erva.model.Fornecedor;
import com.erva.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorDAOJDBCTest {

    private Fornecedor fornecedor;
    private FornecedorDAOJDBC dao;

    @BeforeEach
    void setUp() throws SQLException {
        dao = new FornecedorDAOJDBC();
        fornecedor = new Fornecedor();
        fornecedor.setNome("Nome Original");
        fornecedor.setCpf("98765432100");
        fornecedor.setEndereco("Endereco Original");
        fornecedor.setFornecedorFisico(true);
        dao.removerFornecedor(fornecedor);

        dao.inserirFornecedor(fornecedor);

        Fornecedor ultimo = dao.listarTodosFornecedor()
                .stream()
                .reduce((primeiro, segundo) -> segundo) // pega o último
                .orElse(null);

        assertNotNull(ultimo, "Deveria haver ao menos um fornecedor inserido");
    }

    @Test
    void atualizarFornecedor() throws SQLException {
        fornecedor.setNome("Nome Alterado");
        fornecedor.setEndereco("Endereco Alterado");

        assertDoesNotThrow(() -> {
            dao.atualizarFornecedor(fornecedor);
        });
    }

    @Test
    void inserirFornecedorInvalido() throws SQLException {
        FornecedorDAOJDBC fornecedorDAOJDBC = new FornecedorDAOJDBC();
        Fornecedor fornecedor = new Fornecedor(123);
        fornecedor.setCpf("12345678134214512341912");
        fornecedor.setNome("NomeTeste");
        fornecedor.setEndereco("Rua teste");
        fornecedor.setFornecedorFisico(true);
        fornecedorDAOJDBC.removerFornecedor(fornecedor);
        assertThrows(org.postgresql.util.PSQLException.class, () -> {
            fornecedorDAOJDBC.inserirFornecedor(fornecedor);
        }, "Erro ao inserir fornecedor invalido, excecao de sql nao lançada");
    }
}