package com.erva.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SistemaGestaoPesagem {
    private String nomeSistema;
    private String status;
    private ArrayList<Entrega> lista;

    @Override
    public String toString() {
        return "SisitemaGestaoPesagem{" +
                "nomeSistema='" + nomeSistema + '\'' +
                ", status='" + status + '\'' +
                ", lista=" + lista +
                '}';
    }
}
