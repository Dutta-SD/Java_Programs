package com.sandiplearns.springlearn.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContra implements GamingConsole {
    @Override
    public void up() {
        System.out.println("Jmp Up and down");
    }

    @Override
    public void down() {
        System.out.println("Die");
    }

    @Override
    public void left() {
        System.out.println("Accelerate");
    }

    @Override
    public void right() {
        System.out.println("Decelerate");
    }
}
