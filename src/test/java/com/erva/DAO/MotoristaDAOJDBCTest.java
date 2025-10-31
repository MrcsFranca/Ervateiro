package com.erva.DAO;

import com.erva.model.Motorista;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MotoristaDAOJDBCTest {

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

}