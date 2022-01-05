package com.sandiplearns.springlearn;

import com.sandiplearns.springlearn.game.GameRunner;
import com.sandiplearns.springlearn.game.MarioGame;
import com.sandiplearns.springlearn.game.SuperContra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringLearnApplication.class, args);
		// MarioGame game = new MarioGame();
		// For other Game
		SuperContra game = new SuperContra();
		GameRunner runner = new GameRunner(game);

		runner.run();

	}

}
