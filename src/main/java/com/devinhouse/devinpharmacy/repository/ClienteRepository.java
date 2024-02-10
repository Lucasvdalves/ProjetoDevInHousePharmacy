package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Consulta por CPF (evita duplicação)
    boolean existsByCpf(String cpf);
}
