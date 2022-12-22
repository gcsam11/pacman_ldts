package com.aor.pacman.states;

import com.aor.pacman.controller.Controller;
import com.aor.pacman.controller.game.ArenaController;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.viewer.Viewer;
import com.aor.pacman.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
