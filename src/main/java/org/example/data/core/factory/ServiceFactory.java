package org.example.data.core.factory;
import org.example.data.services.ClientServiceImpl;
import org.example.data.services.UserServiceImpl;
import org.example.data.core.factory.RepositoryFactory;


public class ServiceFactory {
    private static ClientServiceImpl clientServiceImpl=null;
    private static UserServiceImpl userServiceImpl=null;
    public static ClientServiceImpl createClientService() {
        if(clientServiceImpl == null){
            clientServiceImpl = new ClientServiceImpl(RepositoryFactory.createClientRepository());
        }
        return clientServiceImpl;
    }

    public static UserServiceImpl createUserService() {
        if(userServiceImpl == null){
            userServiceImpl = new UserServiceImpl(RepositoryFactory.createUserRepository());
        }
        return userServiceImpl;
    }
    
}
