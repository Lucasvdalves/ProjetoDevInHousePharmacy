package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.CadastrarVacinaDTO;
import com.devinhouse.devinpharmacy.model.dto.VacinaDTO;
import com.devinhouse.devinpharmacy.service.VacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
