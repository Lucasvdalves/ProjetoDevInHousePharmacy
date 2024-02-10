package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.exception.CPFExistenteException;
import com.devinhouse.devinpharmacy.model.Usuarios;
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
}
