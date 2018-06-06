package com.codeoftheweb.salvo;


import com.sun.javafx.collections.MappingChange;
import org.hibernate.mapping.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@RestController
@RequestMapping("/api")
public class SalvoRestController {

    @Autowired
    private GameRepository repo;

    @Autowired
    private PlayerRepository repos;

    @Autowired
    private GamePlayerRepository reposi;

    @RequestMapping("/players")
    public List<Player> getAllp() {
        return repos.findAll();
    }

    //Try something

    @RequestMapping("/games")
    public List<Map<String,Object>> getAllg() {
        return repo.findAll().stream().map(g -> getGameInfo(g)).collect(Collectors.toList());

    }

    public Map<String, Object> getGameInfo(Game game){// we will game and players to the gameplay
        Map<String, Object> myMap = new HashMap<>();

        myMap.put("gameid", game.getId());
        myMap.put("date", game.getCreateDate());
        myMap.put("gameplayer", createGamePlayersMap(game));

        return myMap;
    }

    public List <Object> createGamePlayersMap(Game game){ // this is to get the gameplay
     return game.getGamePlayers().stream().map(gamePlayer ->{
         Map<String, Object> dto = new HashMap<>();
         dto.put("id", gamePlayer.getId());
         dto.put("player", getPlayerInfo(gamePlayer.getPlayer()));
         return dto;
         }).collect(Collectors.toList());
    }

public Map<String, Object> getPlayerInfo (Player player){// is to get just one player

        Map<String, Object> player_dto = new HashMap<>();
            player_dto.put("id", player.getId());
            player_dto.put("Username", player.getUsername());

            return player_dto;
}


@RequestMapping("/game_view/{nn}")
public Map<String, Object> OneGame (@PathVariable long nn){
        GamePlayer selectedGP = reposi.findAll().stream().filter(h -> h.getId() == nn).findFirst().orElse(null);

        Map<String, Object> soloGame = new LinkedHashMap<>();

        if (selectedGP == null){
            soloGame.put("Any gp with this id", nn);
        }else {

            soloGame.put("id", selectedGP.getPlayer().getId());
            soloGame.put("date", selectedGP.getGame().getCreateDate());
            soloGame.put("Username", selectedGP.getPlayer().getUsername());
            soloGame.put("Ships", selectedGP.getFleet());


        }

        return soloGame;
}





    @RequestMapping("/wylker")
    public String sayHello(){
        return "Hello";
    }

}

