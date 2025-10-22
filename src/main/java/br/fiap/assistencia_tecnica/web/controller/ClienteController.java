package br.fiap.assistencia_tecnica.web.controller;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.service.ClienteService;
import br.fiap.assistencia_tecnica.web.dto.ClienteDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
