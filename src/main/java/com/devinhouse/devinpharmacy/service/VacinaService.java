package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.exception.UsuarioNaoEcontratoException;
import com.devinhouse.devinpharmacy.exception.VacinaNaoEcontradaException;
import com.devinhouse.devinpharmacy.model.Cliente;
import com.devinhouse.devinpharmacy.model.Usuarios;
import com.devinhouse.devinpharmacy.model.Vacina;
import com.devinhouse.devinpharmacy.model.dto.AtualizarVacinaDTO;
import com.devinhouse.devinpharmacy.model.dto.CadastrarVacinaDTO;
import com.devinhouse.devinpharmacy.model.dto.EnderecoDTO;
import com.devinhouse.devinpharmacy.model.dto.VacinaDTO;
import com.devinhouse.devinpharmacy.repository.ClienteRepository;
import com.devinhouse.devinpharmacy.repository.UsuariosRepository;
import com.devinhouse.devinpharmacy.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacinaService {
    @Autowired
    private VacinaRepository vacinaRepository;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public VacinaDTO cadastrarVacina(CadastrarVacinaDTO vacina) throws UsuarioNaoEcontratoException {
        Usuarios usuarios = this.usuariosRepository.findById(vacina.usuarioAplicador())
                .orElseThrow(() -> new UsuarioNaoEcontratoException("Farmacêutico não encontrado"));

        Cliente cliente = this.clienteRepository.findById(vacina.usuarioReceptor())
                .orElseThrow(() -> new UsuarioNaoEcontratoException("Cliente não encontrado"));

        Vacina novaVacina = vacinaRepository.save(new Vacina(vacina, usuarios, cliente));
        return new VacinaDTO(novaVacina);
    }

    @Transactional
    public VacinaDTO atualizarVacina(Long id, AtualizarVacinaDTO vacina) throws VacinaNaoEcontradaException {
        Vacina vacinaAtualizada = vacinaRepository.findById(id).orElseThrow(() -> new VacinaNaoEcontradaException("Vacina não encontrada"));
        vacinaAtualizada.setTipoVacina(vacina.tipoVacina() != null ? vacina.tipoVacina() : vacinaAtualizada.getTipoVacina());
        vacinaAtualizada.setObservacoes(vacina.observacoes() != null ? vacina.observacoes() : vacinaAtualizada.getObservacoes());
        return new VacinaDTO(vacinaAtualizada);
    }

    public List<VacinaDTO> listarVacinasDTO() {
        return this.vacinaRepository.findAll().stream().map(VacinaDTO::new).toList();
    }

    public void deletarVacina(Long id) throws VacinaNaoEcontradaException {
        this.vacinaRepository.findById(id).orElseThrow(() -> new VacinaNaoEcontradaException("Vacina não encontrada"));
        this.vacinaRepository.deleteById(id);

    }
}
