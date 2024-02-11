package com.devinhouse.devinpharmacy.controller;

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
