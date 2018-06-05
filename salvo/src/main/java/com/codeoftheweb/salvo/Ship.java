package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class Ship {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ElementCollection
    @Column(name = "locations")
    private List<String> locations;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = “gamePlayerId”)
//    private GamePlayer gamePlayer;

//    @OneToMany(mappedBy="Ship", fetch=FetchType.EAGER)
//    Set<GamePlayer> ShipLocation;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayerId")
    private GamePlayer gamePlayer;


    private String type;

    public long getId() {
        return id;
    }

    public  Ship(){}


}
