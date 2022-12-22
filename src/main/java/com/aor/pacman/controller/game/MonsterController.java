package com.aor.pacman.controller.game;

import com.aor.pacman.Game;
import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.elements.Monster;

import java.io.IOException;
import java.util.List;

public class MonsterController extends GameController {
    private long lastMovement;

    public MonsterController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        int velocity;
        int velocity1 = powerUpVelocityCheck();
        velocity = velocity1;
        velocityCheck(time, velocity);
    }

    public int powerUpVelocityCheck() {
        int velocity;
        boolean poweredUp = getModel().getPacman().isPoweredUp();
        velocity = powerUpCheck(poweredUp);
        return velocity;
    }

    public int powerUpCheck(boolean poweredUp) {
        int velocity;
        if (poweredUp) velocity = 200;
        else velocity = 150;
        return velocity;
    }

    public void velocityCheck(long time, int velocity) {
        if (time - lastMovement > velocity) {
            monsterPosition();
            this.lastMovement = time;
        }
    }

    public void monsterPosition() {
        Position position;
        for (int i = 0; i < getModel().getMonsters().size(); i++) {
            Position randomMonsterPosition = getModel().getRandomMonsterPosition(getModel().getMonsters().get(i).getPosition(), getModel().getMonsters().get(i));
            position = randomMonsterPosition;
            Position position1 = monsterPositionCheck(position);
            position = position1;
            moveMonster(getModel().getMonsters().get(i), position, i);
        }
    }

    public Position monsterPositionCheck(Position position) {
        if (position.getX() == -1) position = new Position(getModel().getWidth()-1, position.getY());
        else {
            position = checkPosition(position);
        }
        return position;
    }

    public Position checkPosition(Position position) {
        if (position.getX() == getModel().getWidth()) {
            int y = position.getY();
            position = new Position(0, y);
        }
        else{
            position = checkPositionY(position);
        }
        return position;
    }

    public Position checkPositionY(Position position) {
        if (position.getY() == -1) position = new Position(position.getX(), getModel().getHeight()-1);
        else if (position.getY() == getModel().getHeight()) position = new Position(position.getX(), 0);
        return position;
    }

    private void moveMonster(Monster monster, Position position, int monsterIndex) {
        monster.setPosition(position);
        boolean equals = getModel().getPacman().getPosition().equals(position);
        checkEquality(monsterIndex, equals);
    }

    private void checkEquality(int monsterIndex, boolean equals) {
        if (equals) {
            boolean poweredUp = getModel().getPacman().isPoweredUp();
            checkMonsterStatus(monsterIndex, poweredUp);
        }
    }

    private void checkMonsterStatus(int monsterIndex, boolean poweredUp) {
        if (poweredUp) {
            getModel().getPacman().addScore(200);
            List<Monster> monsters = getModel().getMonsters();
            monsters.get(monsterIndex).resetPosition(new Position(14, 14));
        }
        else {
            getModel().getPacman().resetPosition(new Position(14, 23));
            int x = 12;
            resetPositionCall(x);
        }
    }

    private void resetPositionCall(int x) {
        for (int i = 0; i < getModel().getMonsters().size(); i++) {
            getModel().getMonsters().get(i).resetPosition(new Position(x, 14));
            x++;
        }
    }
}
