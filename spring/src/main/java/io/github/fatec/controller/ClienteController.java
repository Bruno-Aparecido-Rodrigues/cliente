package io.github.fatec.controller;

import io.github.fatec.controller.adapter.ClienteControllerAdapter;
import io.github.fatec.controller.dto.request.ClienteRequest;
import io.github.fatec.controller.dto.request.ClienteUpdateRequest;
import io.github.fatec.controller.dto.response.ClienteResponse;
import io.github.fatec.entity.Cliente;
import io.github.fatec.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatec/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClienteResponse criar(@RequestBody ClienteRequest request) {
        Cliente cliente = ClienteControllerAdapter.cast(request);
        Cliente criado = repository.salvar(cliente);
        return ClienteControllerAdapter.toResponse(criado);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public ClienteResponse atualizar(@RequestBody ClienteUpdateRequest request) {
        Cliente cliente = ClienteControllerAdapter.cast(request);
        Cliente atualizado = repository.atualizar(cliente);
        return ClienteControllerAdapter.toResponse(atualizado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        repository.deletar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ClienteResponse> listar() {
        return repository.listar()
                .stream()
                .map(ClienteControllerAdapter::toResponse)
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable String id) {
        Cliente cliente = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + id));
        return ClienteControllerAdapter.toResponse(cliente);
    }
}