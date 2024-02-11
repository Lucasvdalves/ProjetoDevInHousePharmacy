package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.model.Endereco;
import com.devinhouse.devinpharmacy.model.dto.CriarEnderecoDTO;
import com.devinhouse.devinpharmacy.model.dto.EnderecoDTO;
import com.devinhouse.devinpharmacy.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public EnderecoDTO cadastrarEndereco(CriarEnderecoDTO endereco) {
        Endereco novoEndereco = this.enderecoRepository.save(new Endereco(endereco));
        return new EnderecoDTO(novoEndereco);
    }

}
