package io.github.fatec.controller.adapter;

import io.github.fatec.controller.dto.request.ClienteRequest;
import io.github.fatec.controller.dto.request.ClienteUpdateRequest;
import io.github.fatec.controller.dto.response.ClienteResponse;
import io.github.fatec.controller.dto.response.EnderecoResponse;
import io.github.fatec.entity.Cliente;
import io.github.fatec.entity.Endereco;

public class ClienteControllerAdapter {

    private ClienteControllerAdapter() {}

    public static Cliente cast(ClienteRequest request) {
        Endereco endereco = null;
        if (request.endereco() != null) {
            endereco = new Endereco(
                    request.endereco().logradouro(),
                    request.endereco().numero(),
                    request.endereco().cidade(),
                    request.endereco().estado()
            );
        }
        return new Cliente(null, request.nome(), request.dataNascimento(), endereco);
    }

    public static Cliente cast(ClienteUpdateRequest request) {
        Endereco endereco = null;
        if (request.endereco() != null) {
            endereco = new Endereco(
                    request.endereco().logradouro(),
                    request.endereco().numero(),
                    request.endereco().cidade(),
                    request.endereco().estado()
            );
        }
        return new Cliente(request.id(), request.nome(), request.dataNascimento(), endereco);
    }

    public static ClienteResponse toResponse(Cliente cliente) {
        EnderecoResponse enderecoResponse = null;
        if (cliente.endereco() != null) {
            enderecoResponse = new EnderecoResponse(
                    cliente.endereco().logradouro(),
                    cliente.endereco().numero(),
                    cliente.endereco().cidade(),
                    cliente.endereco().estado()
            );
        }
        return new ClienteResponse(
                cliente.id(),
                cliente.nome(),
                cliente.dataNascimento(),
                enderecoResponse
        );
    }
}
