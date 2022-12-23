package com.aor.pacman.model;

import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.elements.Monster;
import com.aor.pacman.model.game.elements.Pacman;
import com.aor.pacman.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class ArenaTest {
    Arena stubArena;
    Arena arena;
    
    @BeforeEach
    void init() {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(1, 1));
        walls.add(new Wall(2, 2));
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(1, 3));
        Pacman pacman = new Pacman(2, 1);

        stubArena = Mockito.mock(Arena.class);
        Mockito.when(stubArena.getPacman()).thenReturn(pacman);
        Mockito.when(stubArena.getMonsters()).thenReturn(monsters);
        Mockito.when(stubArena.getWalls()).thenReturn(walls);
        Mockito.when(stubArena.getWidth()).thenReturn(12);
        Mockito.when(stubArena.getHeight()).thenReturn(10);
        Mockito.when(stubArena.getLevel()).thenReturn(1);
        arena = new Arena(stubArena.getLevel(), stubArena.getWidth(), stubArena.getHeight());
        arena.setWalls(walls);
        arena.setMonsters(monsters);
    }

    @Test
    void level() {
        Assertions.assertEquals(1, arena.getLevel());
    }

    @Test
    void paused() {
        arena.setPaused(true);

        Assertions.assertTrue(arena.getPaused());
    }

    @Test
    void width() {
        Assertions.assertEquals(12, arena.getWidth());
    }

    @Test
    void height() {
        Assertions.assertEquals(10, arena.getHeight());
    }

    @Test
    void empty() {
        Position position = new Position(1, 1);
        Mockito.when(stubArena.isEmpty(position)).thenReturn(arena.isEmpty(position));
        Assertions.assertFalse(arena.isEmpty(new Position(1, 1)));
    }

    @Test
    void monster() {
        Position position = new Position(1, 3);
        Mockito.when(stubArena.isMonster(position)).thenReturn(arena.isMonster(position));
        Assertions.assertEquals(0, arena.isMonster(new Position(1, 3)));
    }
}
