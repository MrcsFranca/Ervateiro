package com.erva.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import com.erva.model.Entrega;

public interface EntregaDAO {
    public void insereEntrega(Entrega entrega) throws SQLException;
    public void atualizaEntrega(Entrega entrega) throws SQLException;
    public void removerEntrega(Entrega entrega) throws SQLException;
    public ArrayList<Entrega> listaTodosEntregas() throws SQLException;
}
