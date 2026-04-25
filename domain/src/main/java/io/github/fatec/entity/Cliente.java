package io.github.fatec.entity;

import java.time.LocalDate;

public record Cliente(
        String id,
        String nome,
        LocalDate dataNascimento,
        Endereco endereco
) {}
