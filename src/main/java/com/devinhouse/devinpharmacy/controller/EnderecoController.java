package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.CadastrarVacinaDTO;
import com.devinhouse.devinpharmacy.model.dto.CriarEnderecoDTO;
import com.devinhouse.devinpharmacy.model.dto.EnderecoDTO;
import com.devinhouse.devinpharmacy.model.dto.VacinaDTO;
import com.devinhouse.devinpharmacy.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @PostMapping
    public ResponseEntity<?> cadastroEndereco(@Valid @RequestBody CriarEnderecoDTO endereco) {
        try {
            EnderecoDTO enderecoDTO = this.enderecoService.cadastrarEndereco(endereco);
            return new ResponseEntity<>(enderecoDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
