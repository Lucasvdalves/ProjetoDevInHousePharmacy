package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Consulta por CRF/UF
    boolean existsByCrfUf(String crfUf);

    // Consulta por CPF (evita duplicação)
    boolean existsByCpf(String cpf);
}