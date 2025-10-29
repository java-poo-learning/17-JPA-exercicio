package br.fiap.assistencia_tecnica.web.controller;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.service.ClienteService;
import br.fiap.assistencia_tecnica.web.dto.ClienteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public Cliente criar(@RequestBody ClienteDTO clienteDTO) {
        return service.inserir(clienteDTO);
    }
    @GetMapping
    public List<Cliente> listar () {
        return service.listar();
    }
    @GetMapping("/{id}")
    public Cliente findClienteById(@PathVariable Long id) {
        return service.findClienteById(id);

    }
}

