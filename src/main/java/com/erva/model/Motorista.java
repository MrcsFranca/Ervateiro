package com.erva.model;

public class Motorista {
    private String codMotorista;
    private String nome;
    private String caminhao;
    private Boolean equipeColeta;

    public Motorista(String codMotorista){
        this.codMotorista = codMotorista;
    }

    public void setEquipeColeta(Boolean equipeColeta) {
        this.equipeColeta = equipeColeta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCaminhao(String caminhao) {
        this.caminhao = caminhao;
    }

    public String getNome() {
        return nome;
    }

    public String getCodMotorista() {
        return codMotorista;
    }

    public String getCaminhao() {
        return caminhao;
    }

    public Boolean getEquipeColeta() {
        return equipeColeta;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
