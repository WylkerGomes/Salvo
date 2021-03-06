package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);

	}


	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository,
                                      GameRepository gameRepository,
                                      GamePlayerRepository gamePlayerRepository,
                                      ShipRepository shipRepository) {



        Player p1 = new Player("RUI", "SAO", "TEJO");
        Player p2 = new Player("SILVA", "ECOLA", "SALVADOR");
        Player p3 = new Player("TANIA", "SCOLA", "DOR");
        Player p4 = new Player("JOANA", "ESLA", "ALVA");
        Player p5 = new Player("ILVA", "ELA", "VADOR");
        Player p6 = new Player("IVA", "ESCOL", "SALADO");
        Player p7 = new Player("SA", "ESCO", "ADOR");
        Player p8 = new Player("SILA", "COLA", "SAL");
        Player p9 = new Player("ILA", "SOLA", "LADOR");
        Player p10 = new Player("SIA", "ESOA", "SAVA");





		return (args) -> {
			// save players


			playerRepository.save(p1);
			playerRepository.save(p2);
            playerRepository.save(p3);
            playerRepository.save(p4);
            playerRepository.save(p5);
            playerRepository.save(p6);
            playerRepository.save(p7);
            playerRepository.save(p8);
            playerRepository.save(p9);
            playerRepository.save(p10);

			Game g1 = new Game();
			Game g2 = new Game();
			Game g3 = new Game();
			Game g4 = new Game();
			Game g5 = new Game();


			gameRepository.save(g1);
			gameRepository.save(g2);
			gameRepository.save(g3);
			gameRepository.save(g4);
			gameRepository.save(g5);


			GamePlayer gp1 = new GamePlayer( p1, g1 );
            GamePlayer gp2 = new GamePlayer( p2, g1 );
            GamePlayer gp3 = new GamePlayer( p3, g2 );
            GamePlayer gp4 = new GamePlayer( p4, g2 );
            GamePlayer gp5 = new GamePlayer( p5, g3 );
            GamePlayer gp6 = new GamePlayer( p6, g3 );
            GamePlayer gp7 = new GamePlayer( p7, g4 );
            GamePlayer gp8 = new GamePlayer( p8, g4 );
            GamePlayer gp9 = new GamePlayer( p9, g5 );
            GamePlayer gp10 = new GamePlayer( p10, g5 );



			gamePlayerRepository.save (gp1);
            gamePlayerRepository.save (gp2);
            gamePlayerRepository.save (gp3);
            gamePlayerRepository.save (gp4);
            gamePlayerRepository.save (gp5);
            gamePlayerRepository.save (gp6);
            gamePlayerRepository.save (gp7);
            gamePlayerRepository.save (gp8);
            gamePlayerRepository.save (gp9);
            gamePlayerRepository.save (gp10);

            List<String> loc1 = Arrays.asList("H2","H3", "H4");
            List<String> loc2 = Arrays.asList("HE1", "F1", "G1");
            List<String> loc3 = Arrays.asList("B4", "B5");
            List<String> loc4 = Arrays.asList("B5", "C5", "D5");
            List<String> loc5 = Arrays.asList("F1", "F2");
            List<String> loc6 = Arrays.asList("A2", "A3", "A4");
            List<String> loc7 = Arrays.asList("C6", "C7");
            List<String> loc8 = Arrays.asList("G6", "H6");


            Ship s1 = new Ship("Destroyer", loc1);// SHIPS FOR PLAYER NUMBER 1
            Ship s2 = new Ship("Bombardier", loc2);
            Ship s3 = new Ship("AmmunitionShip", loc3);
            Ship s4 = new Ship("Battleship", loc4);
            Ship s5 = new Ship("PetrolBoat", loc5);

            Ship s6 = new Ship("Destroyer", loc6);// SHIPS FOR PLAYER NUMBER 2
            Ship s7 = new Ship("Bombardier", loc7);
            Ship s8 = new Ship("AmmunitionShip", loc8);
            Ship s9 = new Ship("Battleship", loc2);
            Ship s10 = new Ship("PetrolBoat", loc3);

            gp1.addShips(new HashSet<>(Arrays.asList(new Ship[]{s1,s2,s3,s4,s5}))); // just show one player, his game only
            gp2.addShips(new HashSet<>(Arrays.asList(new Ship[]{s6,s7,s8,s9,s10})));


            shipRepository.save(s1);
            shipRepository.save(s2);
            shipRepository.save(s3);
            shipRepository.save(s4);
            shipRepository.save(s5);
            shipRepository.save(s6);
            shipRepository.save(s7);
            shipRepository.save(s8);
            shipRepository.save(s9);
            shipRepository.save(s10);



//            List<String> loc9 = Arrays.asList("");
//            List<String> loc10 = Arrays.asList("");










		};
	}

}

