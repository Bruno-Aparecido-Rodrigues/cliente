package io.github.fatec.repository;

import io.github.fatec.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    Cliente salvar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    void deletar(String id);

    List<Cliente> listar();

    Optional<Cliente> buscarPorId(String id);
}
