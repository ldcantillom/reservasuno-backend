package org.example.airport.model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "scales")
public class Scale {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name="fligh-id", referencedColumnName="id")
    private Flight flight;

    @OneToOne(optional = false)
    @JoinColumn(name="airport-id", referencedColumnName="id")
    private Airport airport;

    @Column
    private LocalDateTime scaleTime;

    @ManyToMany
    @JoinTable(
            name = "scale-flighs",
            joinColumns = @JoinColumn(name = "fligh-id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "client-id", referencedColumnName = "id")
    )
    private List<Flight> flights = new ArrayList<>();

    public void addStudent(Client flih){
        this.flights.add(flight);
    }


}
