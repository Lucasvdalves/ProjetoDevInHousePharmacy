package com.devinhouse.devinpharmacy.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarEnderecoDTO(@NotBlank String cep,
                               @NotBlank String logradouro,
                               @NotBlank String bairro,
                               @NotBlank String cidade,
                               @NotBlank String estado,
                               @NotNull Long numero,
                               String pontoReferencia,
                               String complemento) {
}
