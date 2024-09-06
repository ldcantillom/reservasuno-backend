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
@Table(name = "airlnes")
public class Airlane {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String airlane_code;

    @Column
    private String origin_country;

    @OneToMany(mappedBy="airlane", fetch = FetchType.EAGER)
    private ArrayList<Fligh> flighs;
}
