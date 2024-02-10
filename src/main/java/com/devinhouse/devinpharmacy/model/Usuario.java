package com.devinhouse.devinpharmacy.model;

public class Usuario {

    private String crfUf;
    private String dataFormacao;
    private String senha;

    public String getCrfUf() {
        return crfUf;
    }

    public void setCrfUf(String crfUf) {
        this.crfUf = crfUf;
    }

    public String getDataFormacao() {
        return dataFormacao;
    }

    public void setDataFormacao(String dataFormacao) {
        this.dataFormacao = dataFormacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
