package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.EstatisticasDTO;
import com.devinhouse.devinpharmacy.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<EstatisticasDTO> listarEstatistica() {
        EstatisticasDTO estatisticasDTO = this.estatisticaService.listarEstatisticas();
        return new ResponseEntity<>(estatisticasDTO, HttpStatus.OK);
    }

}
