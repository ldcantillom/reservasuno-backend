package org.example.airport.model;

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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fligh-id", referencedColumnName="id")
    private Fligh fligh;

    @Column
    private LocalDateTime reservationDate;

    @Column
    private int numberOfSeats;

    @OneToMany(mappedBy = "reserve",fetch = FetchType.LAZY)
    private Set<Passanger> passangers;

}
