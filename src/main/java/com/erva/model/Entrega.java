package com.erva.model;

import java.sql.Timestamp;

public class Entrega {
    private int entregaId;
    private Motorista motorista;
    private Fornecedor fornecedor;
    private Funcionario funcionario;
    private Timestamp dataHora;
    private String tipoErva;
    private Double peso;
    private String descricao;

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setEntregaId(int entregaId) {
        this.entregaId = entregaId;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public void setTipoErva(String tipoErva) {
        this.tipoErva = tipoErva;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEntregaId() {
        return entregaId;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getTipoErva() {
        return tipoErva;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }


    public String getDescricao() {
        return descricao;
    }

    public Double getPeso() {
        return peso;
    }

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
