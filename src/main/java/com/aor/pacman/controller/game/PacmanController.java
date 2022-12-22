package com.aor.pacman.controller.game;

import com.aor.pacman.Game;
import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.elements.Monster;

public class PacmanController extends GameController {
    private long lastMovement;

    public PacmanController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    public void movePacmanLeft() {
        if(getPacmanPosition().getLeft().getX() == -1){
            movePacman(new Position(getModel().getWidth()-1, getPacmanPosition().getY()));
        }
        else{
            movePacman(getPacmanPosition().getLeft());
        }
    }

    public void movePacmanRight() {
        if(getPacmanPosition().getRight().getX() == getModel().getWidth()){
            movePacman(new Position(0, getPacmanPosition().getY()));
        }
        else{
            movePacman(getPacmanPosition().getRight());
        }
    }

    public void movePacmanUp() {
        if (getPacmanPosition().getUp().getY() == -1) {
            movePacman(new Position(getPacmanPosition().getUp().getX(), getModel().getHeight()-1));
        }
        else {
            movePacman(getPacmanPosition().getUp());
        }
    }

    public void movePacmanDown() {
        if (getPacmanPosition().getDown().getY() == getModel().getHeight()) {
            movePacman(new Position(getPacmanPosition().getDown().getX(), 0));
        }
        else {
            movePacman(getPacmanPosition().getDown());
        }
    }

    public void movePacman(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPacman().setPosition(position);
            int monsterIndex = getModel().isMonster(position);
            if (monsterIndex != -1) {
                if(getModel().getPacman().isPoweredUp()) {
                    getModel().getPacman().addScore(200);
                    getModel().getMonsters().get(monsterIndex).resetPosition(new Position(14, 14));
                }
                else{
                    getModel().getPacman().resetPosition(new Position(14, 23));
                    int x = 12;
                    for (int i = 0; i < getModel().getMonsters().size(); i++) {
                        getModel().getMonsters().get(i).resetPosition(new Position(x, 14));
                        x++;
                    }
                }
            }
        }
    }

    public Position getPacmanPosition() {
        return getModel().getPacman().getPosition();
    }

    public void verifyActionIsPossible(GUI.ACTION action) {
        switch (action) {
            case UP:
                if (getModel().isEmpty(getPacmanPosition().getUp())) {
                    getModel().getPacman().setFacingDirection(action);
                }
                break;
            case DOWN:
                if (getModel().isEmpty(getPacmanPosition().getDown())) {
                    getModel().getPacman().setFacingDirection(action);
                }
                break;
            case RIGHT:
                if (getModel().isEmpty(getPacmanPosition().getRight())) {
                    getModel().getPacman().setFacingDirection(action);
                }
                break;
            case LEFT:
                if (getModel().isEmpty(getPacmanPosition().getLeft())) {
                    getModel().getPacman().setFacingDirection(action);
                }
                break;
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if(getModel().getPacman().isPoweredUp() && time >= getModel().getPacman().getPowerUpEnd()){
            getModel().getPacman().endPowerUp();
        }
        if (action != GUI.ACTION.NONE) getModel().getPacman().setPressedDirection(action);
        verifyActionIsPossible(getModel().getPacman().getPressedDirection());
        if (time - lastMovement > 150) {
            switch (getModel().getPacman().getFacingDirection()) {
                case UP -> movePacmanUp();
                case DOWN -> movePacmanDown();
                case RIGHT -> movePacmanRight();
                case LEFT -> movePacmanLeft();
            }
            getModel().retrieveCoin(getPacmanPosition(),time);
            this.lastMovement = time;
        }
    }
}
