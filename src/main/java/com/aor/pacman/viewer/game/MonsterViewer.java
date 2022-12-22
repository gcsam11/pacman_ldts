package com.aor.pacman.viewer.game;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        String color = "#b533ff";
        boolean scared = monster.isScared();
        if(scared) color = "#0000FF";
        gui.drawMonster(monster.getPosition(),color);
    }
}
