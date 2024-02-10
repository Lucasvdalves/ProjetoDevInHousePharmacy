package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.exception.CPFExistenteException;
import com.devinhouse.devinpharmacy.exception.EnderecoNaoEcontradoException;
import com.devinhouse.devinpharmacy.exception.UsuarioNaoEcontratoException;
import com.devinhouse.devinpharmacy.model.Cliente;
import com.devinhouse.devinpharmacy.model.Endereco;
import com.devinhouse.devinpharmacy.model.Usuarios;
import com.devinhouse.devinpharmacy.model.dto.*;
import com.devinhouse.devinpharmacy.repository.ClienteRepository;
import com.devinhouse.devinpharmacy.repository.EnderecoRepository;
import com.devinhouse.devinpharmacy.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public ClienteDTO criarCliente(CriarClienteDTO cliente) throws CPFExistenteException, EnderecoNaoEcontradoException {

        boolean existByCpf = this.clienteRepository.existsByCpf(cliente.cpf());
        if (existByCpf) {
            throw new CPFExistenteException("CPF já cadastrado");
        }
        Endereco endereco = this.enderecoRepository.findById(cliente.enderecoId()).orElseThrow(() -> new EnderecoNaoEcontradoException("Endereço não encontrado"));


        Cliente clienteCriado = this.clienteRepository.save(new Cliente(cliente, endereco));
        return new ClienteDTO(clienteCriado);
    }

}
