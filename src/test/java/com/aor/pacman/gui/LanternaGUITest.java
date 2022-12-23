package com.aor.pacman.gui;

import com.aor.pacman.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.NotExtensible;

class LanternaGUITest {
    private LanternaGUI lanternaGUI;
    private TextGraphics tg;

    @BeforeEach
    void init() {
        Screen screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        lanternaGUI = new LanternaGUI(screen);
    }


    @Test
    void drawPacman() {
        lanternaGUI.drawPacman(new Position(1, 1), '|');

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "|");
    }

    @Test
    void drawWall() {
        lanternaGUI.drawWall(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(70, 255, 51));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "#");
    }

    @Test
    void drawMonster() {
        lanternaGUI.drawMonster(new Position(1, 1), "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "@");
    }

    @Test
    void drawCoin() {
        lanternaGUI.drawCoin(new Position(1, 1), 'C', "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "C");
    }

    @Test
    void drawText() {
        lanternaGUI.drawText(new Position(1, 1), "I'm a PacMan", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "I'm a PacMan");
    }
}
