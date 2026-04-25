package io.github.fatec.controller.dto.request;

import java.time.LocalDate;

public record ClienteUpdateRequest(
        String id,
        String nome,
        LocalDate dataNascimento,
        EnderecoRequest endereco
) {}
