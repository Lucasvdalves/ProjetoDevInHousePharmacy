package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Cliente;
import com.devinhouse.devinpharmacy.model.Usuarios;
import com.devinhouse.devinpharmacy.model.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);

    List<Cliente> findByNomeCompleto(String nome);

}