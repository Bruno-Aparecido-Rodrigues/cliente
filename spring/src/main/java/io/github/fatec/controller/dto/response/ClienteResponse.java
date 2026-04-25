package io.github.fatec.controller.dto.response;

import java.time.LocalDate;

public record ClienteResponse(
        String id,
        String nome,
        LocalDate dataNascimento,
        EnderecoResponse endereco
) {}
