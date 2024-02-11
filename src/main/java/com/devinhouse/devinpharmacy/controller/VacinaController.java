package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.exception.UsuarioNaoEcontratoException;
import com.devinhouse.devinpharmacy.exception.VacinaNaoEcontradaException;
import com.devinhouse.devinpharmacy.model.dto.*;
import com.devinhouse.devinpharmacy.service.VacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {
    @Autowired
    private VacinaService vacinaService;
    @PostMapping
    public ResponseEntity<?> cadastrarVacina(@Valid @RequestBody CadastrarVacinaDTO vacina) {
        try {
            VacinaDTO novaVacina = vacinaService.cadastrarVacina(vacina);
            return new ResponseEntity<>(novaVacina, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<?> atulizarVacina(@PathVariable("identificador") Long id, @Valid @RequestBody AtualizarVacinaDTO vacina) {
        try {
            VacinaDTO vacinaDTO = vacinaService.atualizarVacina(id, vacina);
            return new ResponseEntity<>(vacinaDTO, HttpStatus.CREATED);
        } catch (VacinaNaoEcontradaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<VacinaDTO>> listarVacina() {
        List<VacinaDTO> vacinasDTO = this.vacinaService.listarVacinasDTO();
        return vacinasDTO.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(vacinasDTO, HttpStatus.OK);
    }

}
