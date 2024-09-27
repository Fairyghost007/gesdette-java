package org.example.data.repositories.db.impl;

import org.example.data.entities.Client;

public interface ClientRepositoryDb {
    Client selectByPhone(String phone);
}
