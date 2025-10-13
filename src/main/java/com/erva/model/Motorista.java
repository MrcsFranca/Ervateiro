package com.erva.model;

public class Motorista {
    private String codMotorista;
    private String nome;
    private String caminhao;
    private Boolean equipeColeta;

    @Override
    public String toString() {
        return "Motorista{" +
                "codMotorista='" + codMotorista + '\'' +
                ", nome='" + nome + '\'' +
                ", caminhao='" + caminhao + '\'' +
                ", equipeColeta=" + equipeColeta +
                '}';
    }
}
