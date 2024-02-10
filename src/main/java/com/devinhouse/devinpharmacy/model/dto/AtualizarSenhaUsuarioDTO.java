package com.devinhouse.devinpharmacy.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizarSenhaUsuarioDTO (@NotBlank @Size(min = 8) String senha) {
}
