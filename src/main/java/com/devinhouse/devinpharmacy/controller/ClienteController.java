package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.exception.CPFExistenteException;
import com.devinhouse.devinpharmacy.model.Cliente;
import com.devinhouse.devinpharmacy.model.dto.ClienteDTO;
import com.devinhouse.devinpharmacy.model.dto.CriarClienteDTO;
import com.devinhouse.devinpharmacy.model.dto.CriarUsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.model.dto.UsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@Valid @RequestBody CriarClienteDTO cliente) {
        try {
            ClienteDTO novoUsuario = clienteService.criarCliente(cliente);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (CPFExistenteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
