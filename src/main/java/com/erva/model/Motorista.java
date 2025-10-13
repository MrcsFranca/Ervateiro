package com.erva.model;

public class Motorista {
    private String codMotorista;
    private String nome;
    private String caminhao;
    private Boolean equipeColeta;

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
        return "Motorista{" +
                "codMotorista='" + codMotorista + '\'' +
                ", nome='" + nome + '\'' +
                ", caminhao='" + caminhao + '\'' +
                ", equipeColeta=" + equipeColeta +
                '}';
    }
}
