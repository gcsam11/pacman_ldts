package com.aor.pacman.controller.game;

import com.aor.pacman.Game;
import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.game.Pause;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.menu.*;
import com.aor.pacman.states.MenuState;
import com.aor.pacman.viewer.game.PauseViewer;

import java.io.IOException;
import java.util.Objects;

public class ArenaController extends GameController {
    private final PacmanController pacmanController;
    private final MonsterController monsterController;
    private final PauseViewer pauseViewer;

    public ArenaController(Arena arena) {
        super(arena);

        this.pacmanController = new PacmanController(arena);
        this.monsterController = new MonsterController(arena);
        this.pauseViewer = new PauseViewer(new Pause());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setState(new MenuState(new QuitMenuBuilder().createMenu()));
        }
        else if (action == GUI.ACTION.PAUSE  && getModel().getPaused()) {
            getModel().setPaused(false);
        }
        else if (action == GUI.ACTION.PAUSE  || getModel().getPaused()) {
            if(!getModel().getPaused()) getModel().setPaused(true);
            pauseViewer.draw(game.getGUI());
        }
        else if (action == GUI.ACTION.BACK) {
            game.setState(new MenuState(new StartMenuBuilder().createMenu()));
        }
        else if(getModel().getPacman().getLife() == 0) {
            Menu menu = new FailedLevelMenuBuilder().createMenu();
            game.setState(new MenuState(menu));
        }
        else if(getModel().getCoins().isEmpty()){
            game.levelComplete();
            long score = getModel().getPacman().getScore();
            game.setState(new MenuState(new NextLevelMenuBuilder(score, getModel().getLevel()).createMenu()));
        }
        else {
            pacmanController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}