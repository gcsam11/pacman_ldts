package com.aor.pacman.controller;

import com.aor.pacman.Game;
import com.aor.pacman.controller.game.MonsterController;
import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.elements.Monster;
import com.aor.pacman.model.game.elements.Pacman;
import com.aor.pacman.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterControllerTest {
    MonsterController monsterController;
    Pacman pacman;
    Game game;
    Arena arena;

    @BeforeEach
    void init() {
        arena = new Arena(0, 10, 10);
        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        monsterController = new MonsterController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsters() throws IOException {
        pacman = new Pacman(5, 5);
        arena.setPacman(pacman);

        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));

        monsterController.step(game, GUI.ACTION.NONE, 1000);

        Assertions.assertNotEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersClosed() throws IOException {
        pacman = new Pacman(7, 7);
        arena.setPacman(pacman);
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(new Wall(4, 5), new Wall(6, 5), new Wall(5, 4), new Wall(5, 6)));

        for (int i = 0; i < 10; i++)
            monsterController.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        pacman = new Pacman(5, 5);
        arena.setPacman(pacman);
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(new Wall(4, 5), new Wall(6, 5), new Wall(5, 4)));

        long time = 0;

        while (monster.getPosition().equals(new Position(5, 5))) {
            time += 500;
            monsterController.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), monster.getPosition());
    }
}
