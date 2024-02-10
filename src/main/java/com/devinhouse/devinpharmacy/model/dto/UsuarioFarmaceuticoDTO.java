package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.EstadoCivilEnum;
import com.devinhouse.devinpharmacy.model.Usuarios;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UsuarioFarmaceuticoDTO(Long id,
                                     String nomeCompleto,
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
    public UsuarioFarmaceuticoDTO(Usuarios usuarios) {
        this(usuarios.getId(),
                usuarios.getNomeCompleto(),
                usuarios.getGenero(),
                usuarios.getDataNascimento(),
                usuarios.getCpf(),
                usuarios.getRg(),
                usuarios.getEstadoCivil(),
                usuarios.getTelefone(),
                usuarios.getEmail(),
                usuarios.getNaturalidade(),
                usuarios.getCrfUf(),
                usuarios.getDataFormacao());
    }
}
