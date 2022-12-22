package com.aor.pacman.viewer.game;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.elements.Element;
import com.aor.pacman.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        boolean paused = getModel().getPaused();
        if (!paused){
            gui.clear();

            drawElements(gui, getModel().getWalls(), new WallViewer());
            drawElements(gui, getModel().getCoins(), new CoinViewer());
            drawElements(gui, getModel().getMonsters(), new MonsterViewer());
            drawElement(gui, getModel().getPacman(), new PacmanViewer());

            gui.drawText(new Position(0, 0), "Lives: " + getModel().getPacman().getLife(), "#FFD700");
            gui.drawText(new Position(10, 0), "Score: " + getModel().getPacman().getScore(), "#FFD700");

            gui.refresh();
        }
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
