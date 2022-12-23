package com.aor.pacman.model;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PacmanTest {
    Pacman pacman;

    @BeforeEach
    void init() {
        pacman = new Pacman(2, 2);
    }

    @Test
    void lifeDecrease() {
        pacman.decreaseLife();

        Assertions.assertEquals(2, pacman.getLife());
    }

    @Test
    void positionReset() {
        pacman.setPressedDirection(GUI.ACTION.RIGHT);
        pacman.resetPosition(new Position(1, 1));

        Assertions.assertEquals(GUI.ACTION.LEFT, pacman.getPressedDirection());
    }
}
