package com.aor.pacman.model.game.arena;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int level;
    private final int width;
    private final int height;

    private Pacman pacman;

    private List<Monster> monsters;
    private List<Wall> walls;
    private List<Coin> coins;

    private boolean paused;

    public Arena(int level, int width, int height) {
        this.level = level;
        this.width = width;
        this.height = height;
        this.paused = false;
    }
    public int getLevel(){return this.level;}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean getPaused() {
        return paused;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Coin> getCoins() {return coins;}

    public void setCoins(List<Coin> coins) {this.coins = coins;}

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public Position getRandomMonsterPosition(Position position, Monster monster) {
        GUI.ACTION oppositeDirection = monster.getOppositeDirection();
        List<GUI.ACTION> possibleActions = new ArrayList<>();
        if (isEmpty(position.getUp()) && oppositeDirection != GUI.ACTION.UP) possibleActions.add(GUI.ACTION.UP);
        if (isEmpty(position.getDown()) && oppositeDirection != GUI.ACTION.DOWN) possibleActions.add(GUI.ACTION.DOWN);
        if (isEmpty(position.getLeft()) && oppositeDirection != GUI.ACTION.LEFT) possibleActions.add(GUI.ACTION.LEFT);
        if (isEmpty(position.getRight()) && oppositeDirection != GUI.ACTION.RIGHT) possibleActions.add(GUI.ACTION.RIGHT);
        int n = (int) (Math.random() * possibleActions.size());
        GUI.ACTION possibleAction = possibleActions.get(n);
        if (possibleAction == GUI.ACTION.UP) {
            monster.setOppositeDirection(GUI.ACTION.DOWN);
            return position.getUp();
        }
        else if (possibleAction == GUI.ACTION.DOWN) {
            monster.setOppositeDirection(GUI.ACTION.UP);
            return position.getDown();
        }
        else if (possibleAction == GUI.ACTION.LEFT) {
            monster.setOppositeDirection(GUI.ACTION.RIGHT);
            return position.getLeft();
        }
        else {
            monster.setOppositeDirection(GUI.ACTION.LEFT);
            return position.getRight();
        }
    }

    public int isMonster(Position position) {
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getPosition().equals(position)) return i;
        }
        return -1;
    }

    public void retrieveCoin(Position position,long time){
        for(Coin coin : this.coins){
            if(coin.getPosition().equals(position)){
                if(coin.getPowerUp()){
                    this.pacman.startPowerUp(time);
                    this.pacman.addScore(50);
                }
                else{
                    this.pacman.addScore(10);
                }
                this.coins.remove(coin);
                break;
            }
        }
    }

    public void setPacmanObservers(){
        for(Monster monster:this.monsters){
            this.pacman.addPowerUpObserver(monster);
        }
    }
}
