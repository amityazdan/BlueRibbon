package com.amit.blueribbon.Entity;


import com.sun.istack.NotNull;
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

    @NotNull
    @Column(name = "baggageId")
    private String baggageId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "destination")
    private Destination destination;

    @NotNull
    @Column(name = "checkin")
    private boolean checkin;

}
