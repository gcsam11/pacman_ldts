package com.aor.pacman.model.game.arena;

import com.aor.pacman.model.game.elements.Coin;
import com.aor.pacman.model.game.elements.Pacman;
import com.aor.pacman.model.game.elements.Monster;
import com.aor.pacman.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public abstract Arena createArena();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Pacman createPacman();

    protected abstract List<Coin> createCoins();
}
