package com.codeoftheweb.salvo;


import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        //myMap.put ("gamePlayer_id", createGamePlayersMap(game));
//        myMap.put("palyersId", createPlayersMaps() );


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


//    public   List<Object> createPlayersMap (Player player) {
//        return player.getId().stream().map(Player -> {
//            Map<String, Long> dtos = new HashMap<>();
//            return dtos;
//        }).collect(Collectors.toList());
//
//    }

public Map<String, Object> getPlayerInfo (Player player){// is to get just one player

        Map<String, Object> player_dto = new HashMap<>();
            player_dto.put("id", player.getId());
            player_dto.put("Username", player.getUsername());

            return player_dto;
}








    @RequestMapping("/wylker")
    public String sayHello(){
        return "Hello";
    }

//    @GetMapping("/games")
//    public Set<Game> getGame (List<Game>games) {
//        return repo.stream().map(b -> b.getType()).collect(toSet());
//
//    }


//private Map<String, Player> allPlayers (Player player){
//
//      Map<String, Player> gamers = new LinkedHashMap<String, Player>();
//      gamers.put("FirstName", player.getFirstName());
//      gamers.put("LastName", player.getLastName());
//      gamers.put("Username", player.getUsername());
//      return gamers;
//
//
//}

}

