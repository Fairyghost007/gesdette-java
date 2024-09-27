package org.example.data.views;

import java.util.List;
import java.util.Scanner;

import org.example.data.services.ClientServiceImpl;
import org.example.data.services.UserServiceImpl;
import org.example.data.core.config.service.Service;
import org.example.data.core.config.view.impl.ViewImpl;
import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.data.enums.Role;
import org.example.data.repositories.db.UserRepositoryDbImpl;

public class ClientViewImpl extends ViewImpl<Client>{

    private Service<Client> clientServiceImpl;
    private Service<User> userServiceImpl;
    public  ClientViewImpl(Service<Client> clientServiceImpl, Service<User> userServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public Client saisie() {
        Client client = new Client();
        UserServiceImpl userServiceImpl = new UserServiceImpl(new UserRepositoryDbImpl());
        
        System.out.println("Enter surname: ");
        client.setSurname(scanner.nextLine());
        
        System.out.println("Enter phone: ");
        client.setPhone(scanner.nextLine());
        
        System.out.println("Enter address: ");
        client.setAddress(scanner.nextLine());

        handleUserAccountSelection( client, userServiceImpl);
        
        return client;
    }
private void handleUserAccountSelection(Client client, UserServiceImpl userServiceImpl) {
    int choice;
    do {
        System.out.println("1- Create a user account\n2- Assign a user account\n3- Finish"); 
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number (1, 2, or 3):");
            scanner.next(); // Clear the invalid input
        }
        choice = scanner.nextInt();
        scanner.nextLine();  // Clear the newline character after nextInt()

        switch (choice) {
            case 1:
            User newUser = new User();
            System.out.println("Enter email: ");
            newUser.setEmail(scanner.nextLine());
            System.out.println("Enter login: ");
            newUser.setLogin(scanner.nextLine());
            System.out.println("Enter password: ");
            newUser.setPassword(scanner.nextLine());
            newUser.setRole(Role.CLIENT);
            client.setUser(newUser);
            System.out.println("New user account created with role CLIENT.");
            break;
            
                case 2:
                    System.out.println("Assigning an existing user account...");
                    
                    List<User> userList = userServiceImpl.findAll();
                    System.out.println("List of existing user accounts:");
                    for (int i = 0; i < userList.size(); i++) {
                        User user = userList.get(i);
                        System.out.println((i + 1) + ". Login: " + user.getLogin() + ", Email: " + user.getEmail() + ", Role: " + user.getRole());
                    }
                    
                    int choice2;
                    do {
                        System.out.println("Enter the number of the account you want to assign: ");
                        choice2 = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        if (choice2 < 1 || choice2 > userList.size()) {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    } while (choice2 < 1 || choice2 > userList.size());

                    User selectedUser = userList.get(choice2 - 1);
                    
                    client.setUser(selectedUser);
                    System.out.println("User account '" + selectedUser.getEmail() + "' assigned successfully.");
                break;
            
            
            case 3:
                System.out.println("Finishing the operation.");
                client.setUser(null);
                break;
            
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }
    }while (choice != 3); 
} 
    public void afficheClientByPhone(ClientServiceImpl clientService) {
        System.out.println("Enter telephone: ");
        String phone = scanner.nextLine();
        Client client = clientService.search(phone);
        if (client != null) {
            affiche(client);
        } else {
            System.out.println("No client found with phone:"+phone);
        }
    }


  
}
