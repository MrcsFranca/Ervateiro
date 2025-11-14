# Ervateiro
Desenvolvido por:
- Marcos França
- Giulia Mezaroba
- Lucas Polidorio
- Pedro Ribas
---
## 💪 Motivação
Esse projeto foi criado para aprimorar nosso conhecimento em programação orientada a objetos. O projeto inclui, comunicação com banco de dados uso do JavaFX para criação de telas e utilização dos padrões DAO e MVC.

## 📄 Descrição do software

O software consiste em um CRUD para gerenciar as entregas da empresa Terra Do Mate. O software possui as funcionalidades básicas de um CRUD: criar, ler, atualizar e excluir. Essa funções servem para gerenciar os motorista, funcionários, fonecedores e as entregas..

## 🖥️ Detalhamento técnico

O software possui uma interface amigável e simples de se utilizar, possui feedbacks ao usuário e atualizações em tempo real.


## 🗂️ Banco de dados

Link para script sql: https://docs.google.com/document/d/1sBkfm4uLApjHHl3W5LN3U8QfCsoXb4bS8niPTs3Hdsc/edit?usp=sharing

## ⚙️ Configuração do banco:

- Vá para o diretório: src/main/java/com/erva/DAO/  
- Crie um ENUM chamado "DataBaseConfig.java"
- Insira o seguinte código na classe:
 ```java
package com.erva.DAO;

public enum DataBaseConfig {
    URL("SUA_URL_DO_BD"),
    SENHA("SUA_SENHA"),
    USUARIO("SEU_USUARIO");

    private String valor;

    DataBaseConfig(String s) {
        valor = s;
    }

    public String get() {
        return valor;
    }
}
```


## 👀 Testes

Link para documentação de testes implementados: [https://docs.google.com/document/d/1sBkfm4uLApjHHl3W5LN3U8QfCsoXb4bS8niPTs3Hdsc/edit?usp=sharing](https://docs.google.com/document/d/1JutGgenEeNdbi88ZZAvh62cBpyZ_oESQFYhhmmqb9dA/edit?tab=t.0)
