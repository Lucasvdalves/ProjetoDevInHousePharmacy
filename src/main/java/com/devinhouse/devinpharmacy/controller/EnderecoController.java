package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<?> cadastrarEndereco(@RequestBody Endereco endereco) {
        try {
            Endereco novoEndereco = enderecoService.cadastrarEndereco(endereco);
            return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
        } catch (DadosInvalidosException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    // Adicione outros endpoints conforme necessário
}
