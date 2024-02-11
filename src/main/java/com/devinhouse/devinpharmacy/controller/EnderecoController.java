package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.CriarEnderecoDTO;
import com.devinhouse.devinpharmacy.model.dto.EnderecoDTO;
import com.devinhouse.devinpharmacy.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarEndereco() {
        List<EnderecoDTO> enderecoDTOS = this.enderecoService.listaEnderecoDTO();
        return enderecoDTOS.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(enderecoDTOS, HttpStatus.OK);
    }
}
