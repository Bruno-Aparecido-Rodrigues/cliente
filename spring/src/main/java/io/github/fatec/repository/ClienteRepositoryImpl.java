package io.github.fatec.repository;

import io.github.fatec.entity.Cliente;
import io.github.fatec.repository.adapter.ClienteRepositoryAdapter;
import io.github.fatec.repository.mongo.ClienteRepositoryWithMongoDB;
import io.github.fatec.repository.orm.ClienteOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteRepositoryWithMongoDB repository;

    public ClienteRepositoryImpl(ClienteRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteOrmMongo orm = ClienteRepositoryAdapter.castEntity(cliente);
        ClienteOrmMongo ormSaved = repository.save(orm);
        return ClienteRepositoryAdapter.castOrm(ormSaved);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        ClienteOrmMongo orm = ClienteRepositoryAdapter.castEntity(cliente);
        ClienteOrmMongo ormUpdated = repository.save(orm);
        return ClienteRepositoryAdapter.castOrm(ormUpdated);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll()
                .stream()
                .map(ClienteRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        return repository.findById(id)
                .map(ClienteRepositoryAdapter::castOrm);
    }
}
