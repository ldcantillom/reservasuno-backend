package org.example.airport.model;

import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "airport_origin", fetch=FetchType.EAGER)
    private ArrayList<Fligh> flighs;


}
