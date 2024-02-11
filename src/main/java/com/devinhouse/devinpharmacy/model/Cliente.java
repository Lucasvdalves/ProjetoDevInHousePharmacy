package com.devinhouse.devinpharmacy.model;

import com.devinhouse.devinpharmacy.model.dto.CriarClienteDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente extends Pessoa {
    @Column(nullable = false)
    private String contatoEmergencia;
    private String listaAlergias;
    private String convenio;
    private String numeroCarteiraConvenio;
    private LocalDate validadeCarteiraConvenio;
    @OneToMany(mappedBy = "cliente")
    private Set<Vacina> vacinas = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    public Cliente(CriarClienteDTO cliente, Endereco endereco) {
        super(cliente);
        this.contatoEmergencia = cliente.contatoEmergencia();
        this.listaAlergias = cliente.listaAlergias();
        this.convenio = cliente.convenio();
        this.numeroCarteiraConvenio = cliente.numeroCarteiraConvenio();
        this.validadeCarteiraConvenio = cliente.validadeCarteiraConvenio();
        this.endereco = endereco;

    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getListaAlergias() {
        return listaAlergias;
    }

    public void setListaAlergias(String listaAlergias) {
        this.listaAlergias = listaAlergias;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNumeroCarteiraConvenio() {
        return numeroCarteiraConvenio;
    }

    public void setNumeroCarteiraConvenio(String numeroCarteiraConvenio) {
        this.numeroCarteiraConvenio = numeroCarteiraConvenio;
    }

    public LocalDate getValidadeCarteiraConvenio() {
        return validadeCarteiraConvenio;
    }

    public void setValidadeCarteiraConvenio(LocalDate validadeCarteiraConvenio) {
        this.validadeCarteiraConvenio = validadeCarteiraConvenio;
    }

    public Set<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(Set<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

}
