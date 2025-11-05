package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import br.fiap.assistencia_tecnica.web.dto.ClienteDTO;
import br.fiap.assistencia_tecnica.web.dto.EquipamentoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EquipamentoService {
    private final EquipamentoRepository equipamentoRepository;
    private final ClienteRepository clienteRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, ClienteRepository clienteRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Equipamento inserir(EquipamentoDTO dto) {
        var cliente =  clienteRepository.findById(dto.getCliente().getId())
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));


        Equipamento equipamento = new Equipamento();
        equipamento.setId(dto.getId());
        equipamento.setCliente(cliente);
        equipamento.setMarca(dto.getMarca());
        equipamento.setModelo(dto.getModelo());
        equipamento.setTipo(dto.getTipo());
        equipamento.setDataCadastro(dto.getDataCadastro());
        equipamento.setNumeroSerie(dto.getNumeroSerie());
        return equipamentoRepository.save(equipamento);
    }
    public List<Equipamento> listar () {
        return equipamentoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Equipamento findEquipamentoById(Long equipamentoId) {
        return equipamentoRepository.findById(equipamentoId)
                .orElseThrow(() -> new NoSuchElementException("Equipamento não encontrado"));

}
    }
