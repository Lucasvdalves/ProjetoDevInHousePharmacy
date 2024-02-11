package com.devinhouse.devinpharmacy.model;

import com.devinhouse.devinpharmacy.model.dto.CadastrarVacinaDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeVacina;
    @Column(nullable = false)
    private LocalDateTime dataHoraAdministracao;
    @Enumerated(EnumType.STRING)
    private TipoVacinaEnum tipoVacina;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private String observacoes;
    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idFarmaceutico", nullable = false)
    private Usuarios farmaceutico;

    public Vacina(CadastrarVacinaDTO vacina, Usuarios usuarios, Cliente cliente) {
        this.nomeVacina = vacina.nome();
        this.dataHoraAdministracao = LocalDateTime.now();
        this.tipoVacina = vacina.tipoVacina();
        this.quantidade = vacina.quantidade();
        this.observacoes = vacina.observacoes();
        this.farmaceutico = usuarios;
        this.cliente = cliente;
    }

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

    public LocalDateTime getDataHoraAdministracao() {
        return dataHoraAdministracao;
    }

    public void setDataHoraAdministracao(LocalDateTime dataHoraAdministracao) {
        this.dataHoraAdministracao = dataHoraAdministracao;
    }

    public TipoVacinaEnum getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(TipoVacinaEnum tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuarios getFarmaceutico() {
        return farmaceutico;
    }

    public void setFarmaceutico(Usuarios farmaceutico) {
        this.farmaceutico = farmaceutico;
    }
}
