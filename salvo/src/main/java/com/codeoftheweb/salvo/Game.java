package com.codeoftheweb.salvo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy="Game", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;


    private Date createDate;

    public Game(){
        this.createDate = new Date();
    }


    public long getId() {
        return id;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

