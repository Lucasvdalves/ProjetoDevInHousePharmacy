package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.exception.CPFExistenteException;
import com.devinhouse.devinpharmacy.exception.UsuarioNaoEcontratoException;
import com.devinhouse.devinpharmacy.model.Usuarios;
import com.devinhouse.devinpharmacy.model.dto.AtualizarSenhaUsuarioDTO;
import com.devinhouse.devinpharmacy.model.dto.AtualizarUsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.model.dto.CriarUsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.model.dto.UsuarioFarmaceuticoDTO;
import com.devinhouse.devinpharmacy.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Transactional
    public UsuarioFarmaceuticoDTO cadastrarUsuario(CriarUsuarioFarmaceuticoDTO usuario) throws CPFExistenteException {

        boolean existByCpf = this.usuariosRepository.existsByCpf(usuario.cpf());
        if (existByCpf) {
            throw new CPFExistenteException("CPF já cadastrado");
        }
        Usuarios usuarios = this.usuariosRepository.save(new Usuarios(usuario));
        return new UsuarioFarmaceuticoDTO(usuarios);
    }

    @Transactional
    public UsuarioFarmaceuticoDTO atualizarUsuario(Long id, AtualizarUsuarioFarmaceuticoDTO usuario) throws UsuarioNaoEcontratoException {
        Usuarios usuarios = this.usuariosRepository.findById(id).orElseThrow(() -> new UsuarioNaoEcontratoException("Usuário não encontrado"));
        usuarios.setEmail(usuario.email() != null ? usuario.email() : usuarios.getEmail());
        usuarios.setTelefone(usuario.telefone() != null ? usuario.telefone() : usuarios.getTelefone());
        usuarios.setCpf(usuario.cpf() != null ? usuario.cpf() : usuarios.getCpf());
        usuarios.setRg(usuario.rg() != null ? usuario.rg() : usuarios.getRg());
        usuarios.setNomeCompleto(usuario.nomeCompleto() != null ? usuario.nomeCompleto() : usuarios.getNomeCompleto());
        usuarios.setGenero(usuario.genero() != null ? usuario.genero() : usuarios.getGenero());
        usuarios.setDataNascimento(usuario.dataNascimento() != null ? usuario.dataNascimento() : usuarios.getDataNascimento());
        usuarios.setCrfUf(usuario.crfUf() != null ? usuario.crfUf() : usuarios.getCrfUf());
        return new UsuarioFarmaceuticoDTO(usuarios);
    }

    @Transactional
    public UsuarioFarmaceuticoDTO atualizarSenhaUsuario(Long id, AtualizarSenhaUsuarioDTO usuario) throws UsuarioNaoEcontratoException {
        Usuarios usuarios = this.usuariosRepository.findById(id).orElseThrow(() -> new UsuarioNaoEcontratoException("Usuário não encontrado"));
        usuarios.setSenha(usuario.senha());
        return new UsuarioFarmaceuticoDTO(usuarios);
    }
}
