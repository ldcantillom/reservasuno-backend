package org.example.airport.model.entities;

import java.util.List;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "airlanes")
public class Airlane {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String airlaneCode;

    @Column
    private String originCountry;

    @OneToMany(mappedBy="airlane", fetch = FetchType.EAGER)
    private List<Flight> flights;
}
