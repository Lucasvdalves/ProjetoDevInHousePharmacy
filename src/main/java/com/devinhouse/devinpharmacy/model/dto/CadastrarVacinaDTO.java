package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.TipoVacinaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarVacinaDTO(@NotBlank String nome,
                                 @NotNull TipoVacinaEnum tipoVacina,
                                 @NotNull Integer quantidade,
                                 @NotNull Long usuarioAplicador,
                                 @NotNull Long usuarioReceptor,
                                 @NotBlank String observacoes) {

}
