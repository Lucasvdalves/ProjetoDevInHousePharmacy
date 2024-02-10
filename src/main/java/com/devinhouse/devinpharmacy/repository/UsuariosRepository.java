package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    // Consulta por CRF/UF
    boolean existsByCrfUf(String crfUf);

    // Consulta por CPF (evita duplicação)
    boolean existsByCpf(String cpf);
}