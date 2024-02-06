package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.Vacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @PostMapping
    public ResponseEntity<?> cadastrarVacina(@RequestBody Vacina vacina) {
        try {
            Vacina novaVacina = vacinaService.cadastrarVacina(vacina);
            return new ResponseEntity<>(novaVacina, HttpStatus.CREATED);
        } catch (DadosInvalidosException | ClienteNaoEncontradoException | FarmaceuticoNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<?> atualizarVacina(@PathVariable Long identificador, @RequestBody Vacina vacina) {
        try {
            Vacina vacinaAtualizada = vacinaService.atualizarVacina(identificador, vacina);
            return new ResponseEntity<>(vacinaAtualizada, HttpStatus.OK);
        } catch (DadosInvalidosException | VacinaNaoEncontradaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ClienteNaoEncontradoException | FarmaceuticoNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Adicione outros endpoints conforme necessário
}
