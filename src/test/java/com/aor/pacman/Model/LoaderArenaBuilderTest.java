package com.aor.pacman.Model;

import com.aor.pacman.controller.game.PacmanController;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.arena.LoaderArenaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoaderArenaBuilderTest {

    LoaderArenaBuilder loaderArena;

    Arena arena;

    PacmanController pacmanController;

    @BeforeEach
    public void LoadArena() {
        try {
            loaderArena = new LoaderArenaBuilder(0);
            arena = loaderArena.createArena();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void width(){
        int width = 5;

        Assertions.assertEquals(width, loaderArena.getWidth());
    }

    @Test
    public void height(){
        int height = 5;

        Assertions.assertEquals(height, loaderArena.getHeight());
    }

    @Test
    public void CreatePacman(){
        Position endPosition = new Position(2, 2);

        Assertions.assertEquals(endPosition, arena.getPacman().getPosition());
    }
}
