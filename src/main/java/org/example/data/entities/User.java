package org.example.data.entities;


import org.example.data.enums.Role;
import javax.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    @Column(length = 25, unique = true)
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ColumnDefault(value = "true")
    private boolean statut;

    // Navigabilite
    // @OneToOne
    // @JoinColumn(name = "clients_id", nullable = true)
    // private Client client;

}
