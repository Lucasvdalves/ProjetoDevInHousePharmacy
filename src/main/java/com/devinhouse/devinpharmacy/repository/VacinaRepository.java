package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    // Consulta por identificador (evita duplicação)
    boolean existsById(Long id);

    // Consulta por identificador de cliente
    boolean existsByIdCliente(Long idCliente);

    // Consulta por identificador de farmacêutico
    boolean existsByIdFarmaceutico(Long idFarmaceutico);
}