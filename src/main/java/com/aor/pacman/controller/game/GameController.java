package com.aor.pacman.controller.game;

import com.aor.pacman.controller.Controller;
import com.aor.pacman.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
