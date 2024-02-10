package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.EstadoCivilEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizarUsuarioFarmaceuticoDTO( String nomeCompleto,
                                               String genero,
                                              LocalDate dataNascimento,
                                              String cpf,
                                               String rg,
                                               EstadoCivilEnum estadoCivil,
                                               String telefone,
                                               String email,
                                               String naturalidade,
                                               String crfUf,
                                               LocalDate dataFormacao) {
}
