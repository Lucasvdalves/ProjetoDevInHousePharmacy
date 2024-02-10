package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.EstadoCivilEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CriarClienteDTO(@NotBlank String nomeCompleto,
                              @NotBlank String genero,
                              @NotNull LocalDate dataNascimento,
                              @NotBlank String cpf,
                              @NotBlank String rg,
                              @NotNull EstadoCivilEnum estadoCivil,
                              @NotBlank String telefone,
                              @NotBlank String email,
                              @NotBlank String naturalidade,
                              @NotBlank String contatoEmergencia,
                              String listaAlergias,
                              String convenio,
                              String numeroCarteiraConvenio,
                              LocalDate validadeCarteiraConvenio,
                              @NotNull Long enderecoId) {
}
