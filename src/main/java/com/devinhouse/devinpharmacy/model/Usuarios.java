package com.devinhouse.devinpharmacy.model;


import com.devinhouse.devinpharmacy.model.dto.CriarUsuarioFarmaceuticoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Usuarios extends Pessoa {

    @Column(nullable = false)
    private String crfUf;

    @Column(nullable = false)
    private LocalDate dataFormacao;

    @Column(nullable = false)
    private String senha;

    public Usuarios() {
    }
    public Usuarios(CriarUsuarioFarmaceuticoDTO farmaceutico){
        super(farmaceutico);
        this.crfUf = farmaceutico.crfUf();
        this.dataFormacao = farmaceutico.dataFormacao();
        this.senha = farmaceutico.senha();
    }
    public String getCrfUf() {
        return crfUf;
    }

    public void setCrfUf(String crfUf) {
        this.crfUf = crfUf;
    }

    public LocalDate getDataFormacao() {
        return dataFormacao;
    }

    public void setDataFormacao(LocalDate dataFormacao) {
        this.dataFormacao = dataFormacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
