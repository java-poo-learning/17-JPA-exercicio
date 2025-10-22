package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.web.dto.ClienteDTO;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public Cliente inserir(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setSenha(clienteDTO.getSenha());
        return repo.save(cliente);
    }
}
