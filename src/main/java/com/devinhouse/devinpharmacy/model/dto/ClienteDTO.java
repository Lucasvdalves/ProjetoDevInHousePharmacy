package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Cliente;
import com.devinhouse.devinpharmacy.model.EstadoCivilEnum;

import java.time.LocalDate;

public record ClienteDTO(Long id,
                         String nomeCompleto,
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
    public ClienteDTO(Cliente clienteCriado) {
        this(clienteCriado.getId(),
                clienteCriado.getNomeCompleto(),
                clienteCriado.getGenero(),
                clienteCriado.getDataNascimento(),
                clienteCriado.getCpf(),
                clienteCriado.getRg(),
                clienteCriado.getEstadoCivil(),
                clienteCriado.getTelefone(),
                clienteCriado.getEmail(),
                clienteCriado.getNaturalidade(),
                clienteCriado.getContatoEmergencia(),
                clienteCriado.getListaAlergias(),
                clienteCriado.getConvenio(),
                clienteCriado.getNumeroCarteiraConvenio(),
                clienteCriado.getValidadeCarteiraConvenio());
    }

}
