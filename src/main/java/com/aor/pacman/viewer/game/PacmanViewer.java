package com.aor.pacman.viewer.game;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.game.elements.Pacman;

public class PacmanViewer implements ElementViewer<Pacman> {
    @Override
    public void draw(Pacman pacman, GUI gui) {
        char c = '~';
        GUI.ACTION facingDirection = pacman.getFacingDirection();
        c = checkDirection(c, facingDirection);
        gui.drawPacman(pacman.getPosition(),c);
    }

    public char checkDirection(char c, GUI.ACTION facingDirection) {
        switch (facingDirection){
            case UP -> c = '{';
            case DOWN -> c = '|';
            case RIGHT -> c = '}';
        }
        return c;
    }
}
