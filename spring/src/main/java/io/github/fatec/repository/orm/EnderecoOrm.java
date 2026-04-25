package io.github.fatec.repository.orm;

public record EnderecoOrm(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}
