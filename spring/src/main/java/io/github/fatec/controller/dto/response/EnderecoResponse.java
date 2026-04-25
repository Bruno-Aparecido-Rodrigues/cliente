package io.github.fatec.controller.dto.response;

public record EnderecoResponse(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}
