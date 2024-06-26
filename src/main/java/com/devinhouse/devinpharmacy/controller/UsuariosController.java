package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.exception.CPFExistenteException;
import com.devinhouse.devinpharmacy.exception.UsuarioNaoEcontratoException;
import com.devinhouse.devinpharmacy.model.Usuarios;
import com.devinhouse.devinpharmacy.model.dto.AtualizarSenhaUsuarioDTO;
import com.devinhouse.devinpharmacy.model.dto.AtualizarUsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.model.dto.CriarUsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.model.dto.UsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody CriarUsuarioFarmaceuticoDTO usuario) {
        try {
            UsuarioFarmaceuticoDTO novoUsuario = usuarioService.cadastrarUsuario(usuario);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (CPFExistenteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable("identificador") Long id, @Valid @RequestBody AtualizarUsuarioFarmaceuticoDTO usuario) {
        try {
            UsuarioFarmaceuticoDTO novoUsuario = usuarioService.atualizarUsuario(id, usuario);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (UsuarioNaoEcontratoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{identificador}/senha")
    public ResponseEntity<?> atualizarSenha(@PathVariable("identificador") Long id, @Valid @RequestBody AtualizarSenhaUsuarioDTO usuario) {
        try {
            UsuarioFarmaceuticoDTO novoUsuario = usuarioService.atualizarSenhaUsuario(id, usuario);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (UsuarioNaoEcontratoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
