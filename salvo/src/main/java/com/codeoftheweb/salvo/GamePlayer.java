package com.codeoftheweb.salvo;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Player_id")
    private Player Player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Game_id")
    private Game Game;

    public GamePlayer() { }

    public GamePlayer(Player Player, Game Game) {
        this.Player = Player;
        this.Game = Game;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.codeoftheweb.salvo.Player getPlayer() {
        return Player;
    }

    public void setPlayer(com.codeoftheweb.salvo.Player player) {
        Player = player;
    }

    public com.codeoftheweb.salvo.Game getGame() {
        return Game;
    }

    public void setGame(com.codeoftheweb.salvo.Game game) {
        Game = game;
    }
}
