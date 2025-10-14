package com.erva.main;
import com.erva.DAO.EntregaDAOJDBC;
import com.erva.model.Entrega;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) throws SQLException {
        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();
        ArrayList<Entrega> entregas;
        entregas = entregaDAOJDBC.buscarEntregas(null, null, Timestamp.valueOf("2025-10-05 08:00:00"), Timestamp.valueOf("2025-10-05 08:00:00"), 2201.0, null, null);
        for (Entrega entrega : entregas) {
            System.out.println(entrega);
        }
    }
}
