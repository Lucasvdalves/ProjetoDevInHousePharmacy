package com.devinhouse.devinpharmacy.model;

import java.util.Date;

public class Vacina {

    private Long id;
    private String nomeVacina;
    private Date dataHoraAdministracao;
    private String tipoVacina;
    private int quantidade;
    private String observacoes;
    private Long idCliente;
    private Long idFarmaceutico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Date getDataHoraAdministracao() {
        return dataHoraAdministracao;
    }

    public void setDataHoraAdministracao(Date dataHoraAdministracao) {
        this.dataHoraAdministracao = dataHoraAdministracao;
    }

    public String getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(String tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdFarmaceutico() {
        return idFarmaceutico;
    }

    public void setIdFarmaceutico(Long idFarmaceutico) {
        this.idFarmaceutico = idFarmaceutico;
    }
}
