package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.EstadoCivilEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CriarUsuarioFarmaceuticoDTO(@NotBlank String nomeCompleto,
                                          @NotBlank String genero,
                                          @NotNull LocalDate dataNascimento,
                                          @NotBlank String cpf,
                                          @NotBlank String rg,
                                          @NotNull EstadoCivilEnum estadoCivil,
                                          @NotBlank String telefone,
                                          @NotBlank String email,
                                          @NotBlank String naturalidade,
                                          @NotBlank String crfUf,
                                          @NotNull LocalDate dataFormacao,
                                          @NotBlank @Size(min = 8) String senha) {

}
