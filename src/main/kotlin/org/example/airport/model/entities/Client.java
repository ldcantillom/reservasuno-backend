package org.example.airport.model.entities;

import java.util.ArrayList;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String Address;

    @Column(nullable = false)
    private String cell;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private ArrayList<Reserve> reserves;


}
