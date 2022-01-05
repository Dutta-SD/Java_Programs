package com.sandiplearns.springlearn;

import com.sandiplearns.springlearn.game.GameRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);

		GameRunner runner = context.getBean(GameRunner.class);

		runner.run();

	}

}
