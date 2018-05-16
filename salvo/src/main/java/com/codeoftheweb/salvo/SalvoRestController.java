package com.codeoftheweb.salvo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.Set;


import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class SalvoRestController {

    @Autowired
    private GameRepository repo;
    private PlayerRepository repos;

    @RequestMapping("/players")
    public List<Player> getAllp() {
        return repos.findAll();
    }

    @GetMapping("/games")
    public List<Game> getAllg() {
        return repo.findAll();

    }

//    @GetMapping("/games")
//    public Set<Game> getGame (List<Game>games) {
//        return repo.stream().map(b -> b.getType()).collect(toSet());
//
//    }

}

