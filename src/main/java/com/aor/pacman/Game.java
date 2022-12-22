package com.aor.pacman;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.gui.LanternaGUI;
import com.aor.pacman.model.menu.Menu;
import com.aor.pacman.model.menu.StartMenuBuilder;
import com.aor.pacman.states.MenuState;
import com.aor.pacman.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    private int level;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(28, 31);
        this.state = new MenuState(new StartMenuBuilder().createMenu());
        this.level = 1;
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public GUI getGUI() {
        return gui;
    }

    public int getLevel(){return this.level;}

    public void levelComplete(){this.level++;}

    public void resetLevel(){this.level = 1;}

    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }

        gui.close();
    }
}
