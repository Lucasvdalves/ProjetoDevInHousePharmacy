package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Cliente;
import com.devinhouse.devinpharmacy.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);
}