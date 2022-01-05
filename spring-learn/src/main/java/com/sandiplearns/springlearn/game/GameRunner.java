package com.sandiplearns.springlearn.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    // Tight Coupling we need static datatypes
    @Autowired
    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    // we need specific methods
    public void run() {
        game.down();
        game.left();
        game.up();
        game.right();
    }

}
