package io.github.fatec.controller.dto.request;

import java.time.LocalDate;

public record ClienteRequest(
        String nome,
        LocalDate dataNascimento,
        EnderecoRequest endereco
) {}
