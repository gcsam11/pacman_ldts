package com.aor.pacman.viewer;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.game.elements.Pacman;
import com.aor.pacman.viewer.game.PacmanViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PacmanViewerTest {
    private Pacman pacman;
    private PacmanViewer pacmanViewer;
    private GUI gui;

    @BeforeEach
    void init() {
        pacman = new Pacman(10, 10);
        pacmanViewer = new PacmanViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        pacmanViewer.draw(pacman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPacman(pacman.getPosition(), '~');
    }
}