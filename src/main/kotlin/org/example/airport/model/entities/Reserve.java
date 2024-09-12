package org.example.airport.model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
@Table(name = "reservs")
public class Reserve {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client-id", referencedColumnName = "id")
    private Client client;

    @ManyToMany(mappedBy = "reserve-id", fetch=FetchType.EAGER)
    private ArrayList<Reserve> reserves;

    @Column
    private LocalDateTime reservationDate;

    @Column
    private int numberOfSeats;

    @OneToMany(mappedBy = "reserve",fetch = FetchType.LAZY)
    private Set<Passanger> passangers;


}
