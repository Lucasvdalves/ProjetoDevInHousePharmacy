package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.EstadoCivilEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AtualizarClienteDTO(String nomeCompleto,
                                  String genero,
                                  LocalDate dataNascimento,
                                  String cpf,
                                  String rg,
                                  EstadoCivilEnum estadoCivil,
                                  String telefone,
                                  String email,
                                  String naturalidade,
                                  String contatoEmergencia,
                                  String listaAlergias,
                                  String convenio,
                                  String numeroCarteiraConvenio,
                                  LocalDate validadeCarteiraConvenio) {
}
