package com.codeoftheweb.salvo;


import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import static java.util.stream.Collectors.toList;
@Controller
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
    public List<Game> getAllg() {
        return repo.findAll();

    }

//    @GetMapping("/games")
//    public Set<Game> getGame (List<Game>games) {
//        return repo.stream().map(b -> b.getType()).collect(toSet());
//
//    }


private Map<String, Player> allPlayers (Player player){

      Map<String, Player> gamers = new LinkedHashMap<String, Player>();
      gamers.put("FirstName", player.getFirstName());
      gamers.put("LastName", player.getLastName());
      gamers.put("Username", player.getUsername());
      return gamers;


}







}

