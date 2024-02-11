package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.TipoVacinaEnum;
import com.devinhouse.devinpharmacy.model.Vacina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record VacinaDTO(
        Long id,
        String nome,
        LocalDateTime dataAplicacao,
        TipoVacinaEnum tipoVacina,
        Integer quantidade,
        Long usuarioReceptor,
        String observacoes) {


    public VacinaDTO(Vacina novaVacina) {
        this(   novaVacina.getId(),
                novaVacina.getNomeVacina(),
                novaVacina.getDataHoraAdministracao(),
                novaVacina.getTipoVacina(),
                novaVacina.getQuantidade(),
                novaVacina.getCliente().getId(),
                novaVacina.getObservacoes()
        );
    }
}
