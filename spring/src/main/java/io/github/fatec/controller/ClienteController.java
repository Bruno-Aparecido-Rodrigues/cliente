package io.github.fatec.controller;

import io.github.fatec.controller.adapter.ClienteControllerAdapter;
import io.github.fatec.controller.dto.request.ClienteRequest;
import io.github.fatec.controller.dto.request.ClienteUpdateRequest;
import io.github.fatec.controller.dto.response.ClienteResponse;
import io.github.fatec.entity.Cliente;
import io.github.fatec.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fatec/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClienteResponse criar(@RequestBody ClienteRequest request) {
        Cliente cliente = ClienteControllerAdapter.cast(request);
        Cliente criado = service.criar(cliente);
        return ClienteControllerAdapter.toResponse(criado);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public ClienteResponse atualizar(@RequestBody ClienteUpdateRequest request) {
        Cliente cliente = ClienteControllerAdapter.cast(request);
        Cliente atualizado = service.atualizar(cliente);
        return ClienteControllerAdapter.toResponse(atualizado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ClienteResponse> listar() {
        return service.listar()
                .stream()
                .map(ClienteControllerAdapter::toResponse)
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable String id) {
        Cliente cliente = service.buscarPorId(id);
        return ClienteControllerAdapter.toResponse(cliente);
    }
}
