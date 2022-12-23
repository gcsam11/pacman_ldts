package com.aor.pacman.viewer;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.elements.Coin;
import com.aor.pacman.model.game.elements.Monster;
import com.aor.pacman.model.game.elements.Pacman;
import com.aor.pacman.model.game.elements.Wall;
import com.aor.pacman.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaViewerTest {
    private GUI gui;
    private GameViewer gameViewer;
    private Arena arena;

    @BeforeEach
    void init() {
        arena = new Arena(0, 10, 10);
        gui = Mockito.mock(GUI.class);
        gameViewer = new GameViewer(arena);

        arena.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
        arena.setMonsters(Arrays.asList(new Monster(4, 5), new Monster(5, 6)));
        arena.setCoins(Arrays.asList(new Coin(5, 5), new Coin(6, 6)));
        arena.setPacman(new Pacman(5, 8));
    }


    @Test
    void drawWalls() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawMonsters() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(4, 5), "#b533ff");
        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(5, 6), "#b533ff");
    }

    @Test
    void drawCoins() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(5, 5), '.', "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(6, 6), '.', "#FFFFFF");
    }

    @Test
    void drawPacman() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPacman(new Position(5, 8), '~');
    }

    @Test
    void refreshAndClear() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
