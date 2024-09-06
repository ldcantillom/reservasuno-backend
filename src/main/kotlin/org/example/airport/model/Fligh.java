package org.example.airport.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@Table(name = "flighs")
public class Fligh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id-airlane", referencedColumnName = "id")
    private Airlane airlane;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id-airport-origin", referencedColumnName = "id")
    private Airport airport_origin;

    @ManyToOne(optional = false)
    @JoinColumn(name="id-airport-destination", referencedColumnName="id")
    private Airport airport_destination;

    @Column(nullable=false)
    private LocalDateTime departure_time;

    @Column(nullable = false)
    private LocalDateTime arrival_time;

    @Column(nullable = false)
    private int capacity;

    @ManyToMany
    @JoinTable(
            name = "Reserve-Flighs",
            joinColumns = @JoinColumn(name = "fligh-id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "reserve-id", referencedColumnName = "id")
    )
    private List<Reserve> reserves = new ArrayList<>();

    public void addReserve(Reserve reserve){
        this.reserves.add(reserve);
    }


}
