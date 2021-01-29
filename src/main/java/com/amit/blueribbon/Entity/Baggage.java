package com.amit.blueribbon.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "baggage")
public class Baggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "baggageId")
    private String baggageId;

    @ManyToOne
    @JoinColumn(name = "destination")
    private Destination destination;

    @Column(name = "checkin")
    private boolean checkin;

}
