package com.aor.pacman.model.game.elements;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Pacman extends Movable {
    private int life;

    private long score;

    private long powerUpEnd;

    private boolean isPoweredUp;

    private List<PowerUpObserver> observers;

    private GUI.ACTION facingDirection;

    private GUI.ACTION pressedDirection;

    public Pacman(int x, int y) {
        super(x, y);
        this.life = 3;
        this.powerUpEnd = 0;
        this.isPoweredUp = false;
        this.score = 0;
        this.observers = new ArrayList<>();
        this.facingDirection = GUI.ACTION.LEFT;
        this.pressedDirection = GUI.ACTION.LEFT;
    }

    public GUI.ACTION getFacingDirection() {
        return facingDirection;
    }

    public GUI.ACTION getPressedDirection() {
        return pressedDirection;
    }

    public void setFacingDirection(GUI.ACTION action) {
        facingDirection = action;
    }

    public void setPressedDirection(GUI.ACTION action) {
        pressedDirection = action;
    }

    public void decreaseLife() {
        this.life--;
    }

    public int getLife() {
        return life;
    }

    public void addPowerUpObserver(PowerUpObserver powerUpObserver){
        this.observers.add(powerUpObserver);
    }

    public void startPowerUp(long time){
        this.powerUpEnd = time + 10000;
        this.isPoweredUp = true;
        for(PowerUpObserver observer: observers){
            observer.startPowerUp();
        }
    }

    public void endPowerUp(){
        this.isPoweredUp = false;
        for(PowerUpObserver observer: observers){
            observer.endPowerUp();
        }
    }

    public boolean isPoweredUp(){return this.isPoweredUp;}

    public long getPowerUpEnd(){return this.powerUpEnd;}

    public void addScore(long score){
        this.score += score;
    }

    public long getScore(){return this.score;}

    @Override
    public void resetPosition(Position position) {
        setPosition(position);
        decreaseLife();
        facingDirection = GUI.ACTION.LEFT;
        pressedDirection = GUI.ACTION.LEFT;
    }
}
