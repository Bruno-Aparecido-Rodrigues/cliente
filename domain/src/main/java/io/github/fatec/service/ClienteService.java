package io.github.fatec.service;

import io.github.fatec.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente criar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    void deletar(String id);

    List<Cliente> listar();

    Cliente buscarPorId(String id);
}
