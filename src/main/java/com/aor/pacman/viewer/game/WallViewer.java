package com.aor.pacman.viewer.game;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
