package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.model.dto.EstatisticasDTO;
import com.devinhouse.devinpharmacy.repository.ClienteRepository;
import com.devinhouse.devinpharmacy.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VacinaRepository vacinaRepository;

    public EstatisticasDTO listarEstatisticas() {
       return new EstatisticasDTO(this.clienteRepository.count(),this.vacinaRepository.count());
    }
}
