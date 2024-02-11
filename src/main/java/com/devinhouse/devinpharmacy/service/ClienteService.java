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

import java.util.List;

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

    @Transactional
    public ClienteDTO atualizarCliente(Long id, AtualizarClienteDTO cliente) throws UsuarioNaoEcontratoException {
        Cliente clienteAtualizado = this.clienteRepository.findById(id).orElseThrow(() -> new UsuarioNaoEcontratoException("Cliente não encontrado"));
        clienteAtualizado.setEmail(cliente.email() != null ? cliente.email() : clienteAtualizado.getEmail());
        clienteAtualizado.setTelefone(cliente.telefone() != null ? cliente.telefone() : clienteAtualizado.getTelefone());
        clienteAtualizado.setCpf(cliente.cpf() != null ? cliente.cpf() : clienteAtualizado.getCpf());
        clienteAtualizado.setRg(cliente.rg() != null ? cliente.rg() : clienteAtualizado.getRg());
        clienteAtualizado.setNomeCompleto(cliente.nomeCompleto() != null ? cliente.nomeCompleto() : clienteAtualizado.getNomeCompleto());
        clienteAtualizado.setGenero(cliente.genero() != null ? cliente.genero() : clienteAtualizado.getGenero());
        clienteAtualizado.setDataNascimento(cliente.dataNascimento() != null ? cliente.dataNascimento() : clienteAtualizado.getDataNascimento());
        this.clienteRepository.save(clienteAtualizado);
        return new ClienteDTO(clienteAtualizado);

    }

    public List<ClienteDTO> listarCliente(String nome) {
        if (nome != null) {
            return this.clienteRepository.findByNomeCompleto(nome).stream().map(ClienteDTO::new).toList();
        }
        return this.clienteRepository.findAll().stream().map(ClienteDTO::new).toList();
    }

    public ClienteDTO buscarClienteID(Long id) throws UsuarioNaoEcontratoException {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new UsuarioNaoEcontratoException("Cliente não encontrado"));
        return new ClienteDTO(cliente);
    }
    @Transactional
    public void deletarCliente(Long id) throws UsuarioNaoEcontratoException {
        this.clienteRepository.findById(id).orElseThrow(() -> new UsuarioNaoEcontratoException("Cliente não encontrado"));
        this.clienteRepository.deleteById(id);
    }
}
