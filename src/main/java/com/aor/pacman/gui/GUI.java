package com.aor.pacman.gui;

import com.aor.pacman.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPacman(Position position, char character);

    void drawWall(Position position);

    void drawMonster(Position position, String color);

    void drawCoin(Position position, char character, String color);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, BACK, PAUSE, START, NEXT, RESTART}
}
