package org.example.data.services;

import org.example.data.core.config.repository.Repository;
import org.example.data.core.config.service.impl.ServiceImpl;
import org.example.data.entities.Client;
import org.example.data.repositories.db.ClientRepositoryDbImpl;
import org.example.data.repositories.db.impl.ClientRepositoryDb;
import org.example.data.repositories.db.impl.RepositoryJpaImpl;

import java.util.List;

public class ClientServiceImpl extends ServiceImpl<Client> {
    private ClientRepositoryDbImpl clientRepository;
    private RepositoryJpaImpl<Client> repositoryJpaImpl;

    public ClientServiceImpl(ClientRepositoryDbImpl clientRepository) {
        this.clientRepository = clientRepository;
        this.repositoryJpaImpl = new RepositoryJpaImpl<>(Client.class);
    }

    public void create(Client client) {
        clientRepository.insert(client);
    }

    public List<Client> findAll() {
        return repositoryJpaImpl.selectAll();
    }

    public Client search(String phone) {
        return clientRepository.selectByPhone(phone);
    }
}
