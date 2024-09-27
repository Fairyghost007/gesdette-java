package org.example;

import org.example.data.core.factory.RepositoryFactory;
import org.example.data.entities.Client;
import org.example.data.repositories.db.ClientRepositoryDbImpl;
import org.example.data.services.ClientServiceImpl;
import org.example.data.services.UserServiceImpl;
import org.example.data.views.ClientViewImpl;
import org.example.data.views.UserViewImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //repository
        // ClientRepositoryDbImpl clientRepositoryImpl = new ClientRepositoryDbImpl();
        //service
        ClientServiceImpl clientServiceImpl = new ClientServiceImpl(RepositoryFactory.createClientRepository());
        UserServiceImpl userServiceImpl = new UserServiceImpl(RepositoryFactory.createUserRepository());
        //views
        ClientViewImpl clientView = new ClientViewImpl(clientServiceImpl,userServiceImpl);
        UserViewImpl userView = new UserViewImpl(userServiceImpl);

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1- Create client");
            System.out.println("2- List client");
            System.out.println("3- Find client by phone");
            System.out.println("4- Creer compte user");
            System.out.println("5- List user");
            System.out.println("6- Quiter");
            choice = scanner.nextInt();

            
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    clientServiceImpl.create(clientView.saisie());
                    break;
                }
                case 2 -> {
                    clientView.affiche(clientServiceImpl.findAll());
                    break;
                }
                case 3 -> {
                    clientView.afficheClientByPhone(clientServiceImpl);
                    break;
                }
                case 4 -> {
                    userServiceImpl.create(userView.saisie());
                    break;
                }
                case 5 -> {
                    userView.affiche(userServiceImpl.findAll());

                    break;
                }
            }
        } while (choice != 6);


    }
}