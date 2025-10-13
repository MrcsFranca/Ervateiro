package com.erva.model;

import java.sql.Timestamp;

public class Entrega {
    private String entregaId;
    private Motorista motorista;
    private Fornecedor fornecedor;
    private Funcionario funcionario;
    private Timestamp dataHora;
    private String tipoErva;
    private Double peso;
    private String descricao;

    @Override
    public String toString() {
        return "Entrega{" +
                "entregaId='" + entregaId + '\'' +
                ", motorista=" + motorista +
                ", fornecedor=" + fornecedor +
                ", funcionario=" + funcionario +
                ", dataHora=" + dataHora +
                ", tipoErva='" + tipoErva + '\'' +
                ", peso=" + peso +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Double calculaValor(Double valorArroba) {
        return valorArroba * (peso / 15);
    }
}
