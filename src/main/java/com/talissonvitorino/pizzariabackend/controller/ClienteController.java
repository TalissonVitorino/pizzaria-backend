package com.talissonvitorino.pizzariabackend.controller;

import com.talissonvitorino.pizzariabackend.service.ClienteService;
import com.talissonvitorino.pizzariabackend.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cliente")
    public Cliente cadastrarNovoCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    @GetMapping("/cliente")
    public List<Cliente> listarTodosOsClientes() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/cliente/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Void> deletarClientePorId(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
