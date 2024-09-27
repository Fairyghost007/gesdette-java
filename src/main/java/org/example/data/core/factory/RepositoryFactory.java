package org.example.data.core.factory;

import org.example.data.repositories.db.ClientRepositoryDbImpl;
import org.example.data.repositories.db.UserRepositoryDbImpl;

public class RepositoryFactory {

    private static ClientRepositoryDbImpl clientRepositoryDbImpl=null;
    private static UserRepositoryDbImpl userRepositoryDbImpl=null;
    public static ClientRepositoryDbImpl createClientRepository() {
        if(clientRepositoryDbImpl == null){
            clientRepositoryDbImpl = new ClientRepositoryDbImpl();
        }
        return clientRepositoryDbImpl;
    }

    public static UserRepositoryDbImpl createUserRepository() {
        if(userRepositoryDbImpl == null){
            userRepositoryDbImpl = new UserRepositoryDbImpl();
        }
        return userRepositoryDbImpl;
    }
}
