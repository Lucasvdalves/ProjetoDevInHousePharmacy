package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.exception.CPFExistenteException;
import com.devinhouse.devinpharmacy.exception.UsuarioNaoEcontratoException;
import com.devinhouse.devinpharmacy.model.Cliente;
import com.devinhouse.devinpharmacy.model.dto.*;
import com.devinhouse.devinpharmacy.service.ClienteService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{identificador}")
    public ResponseEntity<?> atualizarCliente(@PathVariable("identificador") Long id, @RequestBody AtualizarClienteDTO cliente) {
        try {
            ClienteDTO novoUsuario = clienteService.atualizarCliente(id, cliente);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (UsuarioNaoEcontratoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarCliente(@RequestParam(required = false, name = "nome") String nome) {
        List<ClienteDTO> clienteDTOS = this.clienteService.listarCliente(nome);
        return clienteDTOS.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(clienteDTOS, HttpStatus.OK);
    }


}
