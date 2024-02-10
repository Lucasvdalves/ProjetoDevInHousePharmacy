package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    // Consulta por CPF
    boolean existsByCpf(String cpf);
}