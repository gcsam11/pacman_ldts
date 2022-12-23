package com.aor.pacman.model;

import com.aor.pacman.controller.game.PacmanController;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.arena.LoaderArenaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LoaderArenaBuilderTest {

    LoaderArenaBuilder loaderArena;

    Arena arena;

    PacmanController pacmanController;

    @BeforeEach
    void LoadArena() {
        try {
            loaderArena = new LoaderArenaBuilder(0);
            arena = loaderArena.createArena();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    void width(){
        int width = 5;

        Assertions.assertEquals(width, loaderArena.getWidth());
    }

    @Test
    void height(){
        int height = 5;

        Assertions.assertEquals(height, loaderArena.getHeight());
    }

    @Test
    void createPacman(){
        Position endPosition = new Position(2, 2);

        Assertions.assertEquals(endPosition, arena.getPacman().getPosition());
    }

    @Test
    void walls() {
        Assertions.assertEquals(12, arena.getWalls().size());
    }

    @Test
    void monster() {
        Assertions.assertEquals(1, arena.getMonsters().size());
    }

    @Test
    void coins() {
        Assertions.assertEquals(11, arena.getCoins().size());
    }
}
