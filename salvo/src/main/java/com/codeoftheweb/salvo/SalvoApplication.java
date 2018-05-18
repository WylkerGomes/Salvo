package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);

	}


	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository,
                                      GameRepository gameRepository,
                                      GamePlayerRepository gamePlayerRepository) {


		return (args) -> {
			// save players
            Player p1 = new Player();
            Player p2 = new Player();
            Player p3 = new Player();
            Player p4 = new Player();
            Player p5 = new Player();
            Player p6 = new Player();
            Player p7 = new Player();
            Player p8 = new Player();
            Player p9 = new Player();
            Player p10 = new Player();

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


			gamePlayerRepository.save (new GamePlayer( p1, g1 ));
			gamePlayerRepository.save (new GamePlayer( p2, g1 ));
            gamePlayerRepository.save (new GamePlayer( p3, g2 ));
            gamePlayerRepository.save (new GamePlayer( p4, g2 ));
            gamePlayerRepository.save (new GamePlayer( p5, g3 ));
            gamePlayerRepository.save (new GamePlayer( p6, g3 ));
            gamePlayerRepository.save (new GamePlayer( p7, g4 ));
            gamePlayerRepository.save (new GamePlayer( p8, g4 ));
            gamePlayerRepository.save (new GamePlayer( p9, g5 ));
            gamePlayerRepository.save (new GamePlayer( p10, g5 ));


		};
	}

}

