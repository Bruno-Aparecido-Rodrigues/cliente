package io.github.fatec.controller.dto.request;

public record EnderecoRequest(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}
