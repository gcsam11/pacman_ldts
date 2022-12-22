package com.aor.pacman.model.game.elements;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;

public class Monster extends Movable implements PowerUpObserver{
    private boolean isScared;
    private GUI.ACTION oppositeDirection;
    public Monster(int x, int y) {
        super(x, y);
        this.isScared = false;
        this.oppositeDirection = GUI.ACTION.NONE;
    }

    public boolean isScared(){return this.isScared;}

    public GUI.ACTION getOppositeDirection() {
        return oppositeDirection;
    }

    public void setOppositeDirection(GUI.ACTION action) {
        oppositeDirection = action;
    }

    @Override
    public void startPowerUp() {
        this.isScared = true;
    }

    @Override
    public void endPowerUp() {
        this.isScared = false;
    }

    @Override
    public void resetPosition(Position position) {
        setPosition(position);
    }
}
