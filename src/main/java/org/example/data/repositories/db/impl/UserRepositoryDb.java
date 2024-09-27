package org.example.data.repositories.db.impl;

import org.example.data.entities.Client;
import org.example.data.entities.User;

public interface UserRepositoryDb {
    User selectByLogin(String login);
    User selectById(int id);

}
