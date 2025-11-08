package com.erva.DAO;

import com.erva.model.Motorista;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MotoristaDAOJDBCTest {
    private MotoristaDAOJDBC dao;
    private Motorista motorista;

    @BeforeEach
    void setUp() throws SQLException {
        dao = new MotoristaDAOJDBC();
        motorista = new Motorista("12345");
        motorista.setNome("Nome Teste");
        motorista.setCaminhao("Mercedes-Benz on Autobahen");
        motorista.setEquipeColeta(false);
        dao.inserirMotorista(motorista);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (motorista != null) {
            dao.removerMotorista(motorista);
        }
    }

    @Test
    void inserirMotorista() throws SQLException {
        com.erva.DAO.MotoristaDAOJDBC motoristaDAOJDBC = new MotoristaDAOJDBC();
        Motorista motorista = new Motorista("07050680990");
        motorista.setNome("Lucas Pol");
        motorista.setEquipeColeta(false);
        motorista.setCaminhao("Scannia 113");
        motoristaDAOJDBC.removerMotorista(motorista);
        assertDoesNotThrow(() -> {
            motoristaDAOJDBC.inserirMotorista(motorista);
        }, "Erro ao inserir motorista, excecao de sql lançada");
        motoristaDAOJDBC.removerMotorista(motorista);
    }
    @Test
    void inserirMotoristaInvalido() throws SQLException {
        com.erva.DAO.MotoristaDAOJDBC motoristaDAOJDBC = new MotoristaDAOJDBC();
        Motorista motorista = new Motorista("07050680990000000000000000");
        motorista.setNome("Lucas Pol");
        motorista.setEquipeColeta(false);
        motorista.setCaminhao("Scannia 113");
        motoristaDAOJDBC.removerMotorista(motorista);
        assertThrows(org.postgresql.util.PSQLException.class, () -> {
            motoristaDAOJDBC.inserirMotorista(motorista);
        }, "Erro ao inserir motorista invalido, excecao de sql nao lançada");
    }
    @Test
    void buscarMotorista() throws SQLException {
        com.erva.DAO.MotoristaDAOJDBC motoristaDAOJDBC = new MotoristaDAOJDBC();
        Motorista motorista = new Motorista("07050680990");
        motorista.setNome("Lucas Pol");
        motorista.setEquipeColeta(false);
        motorista.setCaminhao("Scannia 113");
        assertDoesNotThrow(() -> {
            motoristaDAOJDBC.buscaMotorista(motorista);
        }, "Erro ao buscar motorista, excecao de sql lançada");
    }

    @Test
    void removerMotoristaInexistente() throws SQLException {
        Motorista motoristaInexistente = new Motorista("99999");

        assertDoesNotThrow(() -> {
            dao.removerMotorista(motoristaInexistente);
        }, "Remoção de motorista inexistente não deveria lançar exceções");

    }

}