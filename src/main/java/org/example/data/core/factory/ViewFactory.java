package org.example.data.core.factory;
import org.example.data.core.factory.RepositoryFactory;
import org.example.data.core.factory.ServiceFactory;
import org.example.data.views.ClientViewImpl;
import org.example.data.views.UserViewImpl;


public class ViewFactory {
    private static ClientViewImpl clientViewImpl=null;
    private static UserViewImpl userViewImpl=null;
    public static ClientViewImpl createClientService() {
        if(clientViewImpl == null){
            clientViewImpl = new ClientViewImpl(ServiceFactory.createClientService(),ServiceFactory.createUserService());
        }
        return clientViewImpl;
    }

    public static UserViewImpl createUserService() {
        if(userViewImpl == null){
            userViewImpl = new UserViewImpl(ServiceFactory.createUserService());
        }
        return userViewImpl;
    }
    
}
