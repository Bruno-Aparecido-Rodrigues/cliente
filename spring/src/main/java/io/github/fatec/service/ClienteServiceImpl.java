package io.github.fatec.service;

import io.github.fatec.entity.Cliente;
import io.github.fatec.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        return repository.salvar(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return repository.atualizar(cliente);
    }

    @Override
    public void deletar(String id) {
        repository.deletar(id);
    }

    @Override
    public List<Cliente> listar() {
        return repository.listar();
    }

    @Override
    public Cliente buscarPorId(String id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + id));
    }
}
