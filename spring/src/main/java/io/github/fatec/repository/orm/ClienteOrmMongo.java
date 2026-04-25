package io.github.fatec.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "clientes")
public record ClienteOrmMongo(
        @Id
        String id,
        String nome,
        LocalDate dataNascimento,
        EnderecoOrm endereco
) {}
