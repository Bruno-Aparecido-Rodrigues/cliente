package io.github.fatec.repository.adapter;

import io.github.fatec.entity.Cliente;
import io.github.fatec.entity.Endereco;
import io.github.fatec.repository.orm.ClienteOrmMongo;
import io.github.fatec.repository.orm.EnderecoOrm;

public class ClienteRepositoryAdapter {

    private ClienteRepositoryAdapter() {}

    public static Cliente castOrm(ClienteOrmMongo orm) {
        Endereco endereco = null;
        if (orm.endereco() != null) {
            endereco = new Endereco(
                    orm.endereco().logradouro(),
                    orm.endereco().numero(),
                    orm.endereco().cidade(),
                    orm.endereco().estado()
            );
        }
        return new Cliente(
                orm.id(),
                orm.nome(),
                orm.dataNascimento(),
                endereco
        );
    }

    public static ClienteOrmMongo castEntity(Cliente entity) {
        EnderecoOrm enderecoOrm = null;
        if (entity.endereco() != null) {
            enderecoOrm = new EnderecoOrm(
                    entity.endereco().logradouro(),
                    entity.endereco().numero(),
                    entity.endereco().cidade(),
                    entity.endereco().estado()
            );
        }
        return new ClienteOrmMongo(
                entity.id(),
                entity.nome(),
                entity.dataNascimento(),
                enderecoOrm
        );
    }
}
