package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Endereco;

public record EnderecoDTO(
        Long id,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        Long numero,
        String pontoReferencia,
        String complemento
) {
    public EnderecoDTO(Endereco novoEndereco) {
        this(novoEndereco.getId(),
                novoEndereco.getCep(),
                novoEndereco.getLogradouro(),
                novoEndereco.getBairro(),
                novoEndereco.getCidade(),
                novoEndereco.getEstado(),
                novoEndereco.getNumero(),
                novoEndereco.getPontoReferencia(),
                novoEndereco.getComplemento());

    }
}
