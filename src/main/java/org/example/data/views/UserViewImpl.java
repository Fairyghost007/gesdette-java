package org.example.data.views;

import org.example.data.core.config.service.Service;
import org.example.data.core.config.view.impl.ViewImpl;
import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.data.enums.Role;
import org.example.data.services.ClientServiceImpl;
import org.example.data.services.UserServiceImpl;

public class UserViewImpl extends ViewImpl<User>{

    private Service<User> userServiceImpl;
    public  UserViewImpl(Service<User> userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public User saisie() {
        User user = new User();
        System.out.println("Enter email: ");
        user.setEmail(scanner.nextLine());
        System.out.println("Enter login: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Enter password: ");
        user.setPassword(scanner.nextLine());
        System.out.println("Select a role:");
        Role[] roles = Role.values();
        for (int i = 0; i < roles.length; i++) {
            System.out.println(i + 1 + ". " + roles[i]);
        }
        int roleChoice;
        do {
            System.out.print("Enter the number corresponding to the role: ");
            roleChoice = scanner.nextInt();
            scanner.nextLine(); 
        } while (roleChoice < 1 || roleChoice > roles.length);
        user.setRole(roles[roleChoice - 1]);
        return user;
    }


    public User findUserByLogin(UserServiceImpl userServiceImpl) {
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        User user = userServiceImpl.search(login);
        if (user != null) {
            affiche(user);
        } else {
            System.out.println("No client found with phone:"+user);
        }
        return user;
    }

    
    
}
