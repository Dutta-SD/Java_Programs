package com.sandiplearns.springlearn.game;

public class GameRunner {
    // Tight Coupling we need static datatypes
    private MarioGame game;

    public GameRunner(MarioGame game) {
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
