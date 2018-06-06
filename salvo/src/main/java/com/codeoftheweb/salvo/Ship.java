package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ElementCollection
    @Column(name = "locations")
    private List<String> locations;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayerId")
    private GamePlayer gamePlayer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public  Ship(){}

    public  Ship(String inputType){
        this.type = inputType;
    }


    public long getId() {
        return id;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}
