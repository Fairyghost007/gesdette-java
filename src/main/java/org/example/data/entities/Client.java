package org.example.data.entities;
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
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 25, unique = true)
    private String surname;
    @Column(length = 11, unique = true)
    private String phone;
    @Column(length = 255, unique = false)
    private String address;

    // Navigabilite
    @OneToOne
    private User user;
}
