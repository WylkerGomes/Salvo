package com.codeoftheweb.salvo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;


    /////////////////////////////////////////////////////


    @OneToMany(mappedBy="Player", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;


//    public void addPlayer( Player gamers) {
//
//        gamers.setUsername("");
//        players.add(gamers);
//    }


    //////////////////////////////////////////////////////



    private String firstName;
    private String lastName;
    private String username;

    public long getId() {
        return id;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public  Player(){}


    public Player(String first, String last, String user){

        this.firstName = first;
        this.lastName = last;
        this.username = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}