package com.aor.pacman.model.game.elements;

import com.aor.pacman.model.Position;

public class Movable extends Element {
    public Movable(int x, int y) {
        super(x, y);
    }

    public void resetPosition(Position position) {
        // override method
    }
}
