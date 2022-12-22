package com.aor.pacman.model.game.elements;

import com.aor.pacman.model.Position;

public class Coin extends Element{
    private boolean isPowerUp;
    public Coin(int x, int y) {
        super(x, y);
        this.isPowerUp = false;
    }
    public Coin(Position position){
        this(position.getX(),position.getY());
        this.isPowerUp = false;
    }

    public Coin(int x, int y,boolean isPowerUp){
        super(x,y);
        this.isPowerUp = isPowerUp;
    }

    public void setPowerUp(boolean isPowerUp){this.isPowerUp = isPowerUp;}

    public boolean getPowerUp(){return this.isPowerUp;}
}
