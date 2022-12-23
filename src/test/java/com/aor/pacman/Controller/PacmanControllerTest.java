package com.aor.pacman.controller;

import com.aor.pacman.controller.game.PacmanController;
import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
import com.aor.pacman.model.game.arena.LoaderArenaBuilder;
import com.aor.pacman.model.game.elements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

class PacmanControllerTest {
    Arena arena;
    PacmanController pacmanController;
    Pacman pacman;
    GUI.ACTION action;

    @BeforeEach
    public void init() {
        try {
            arena = new LoaderArenaBuilder(0).createArena();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        pacmanController = new PacmanController(arena);
        pacman = new Pacman(arena.getPacman().getPosition().getX(), arena.getPacman().getPosition().getY());
    }

    @Test
    void moveUp() {
        pacmanController.movePacmanUp();

        Assertions.assertEquals(new Position(2,1), pacmanController.getPacmanPosition());
    }

    @Test
    void moveDown(){
        pacmanController.movePacmanDown();

        Assertions.assertEquals(new Position(2,3), pacmanController.getPacmanPosition());
    }

    @Test
    void moveLeft(){
        pacmanController.movePacmanLeft();

        Assertions.assertEquals(new Position(1,2), pacmanController.getPacmanPosition());
    }

    @Test
    void moveRight(){
        pacmanController.movePacmanRight();

        Assertions.assertEquals(new Position(3,2), pacmanController.getPacmanPosition());
    }

    @Test
    void moveEmpty() {
        pacmanController.movePacmanUp();
        pacmanController.movePacmanLeft();

        Assertions.assertEquals(new Position(1, 1), pacmanController.getPacmanPosition());
    }

    @Test
    void moveLeftWithHiddenPath(){
        pacmanController.movePacman(new Position(0, 2));
        Position endPosition = new Position(4, 2);

        pacmanController.movePacmanLeft();

        Assertions.assertEquals(endPosition, pacmanController.getPacmanPosition());
    }

    @Test
    void moveRightWithHiddenPath(){
        pacmanController.movePacman(new Position(4 , 2));
        Position endPosition = new Position(0, 2);

        pacmanController.movePacmanRight();

        Assertions.assertEquals(endPosition, pacmanController.getPacmanPosition());
    }

    @Test
    void moveUpWithHiddenPath(){
        pacmanController.movePacman(new Position(2, 0));
        Position endPosition = new Position(2, 4);

        pacmanController.movePacmanUp();

        Assertions.assertEquals(endPosition, pacmanController.getPacmanPosition());
    }

    @Test
    void moveDownWithHiddenPath(){
        pacmanController.movePacman(new Position(2, 4));
        Position endPosition = new Position(2, 0);

        pacmanController.movePacmanDown();

        Assertions.assertEquals(endPosition, pacmanController.getPacmanPosition());
    }

    @Test
    void verifyActionPossible() {
        action = GUI.ACTION.DOWN;

        Assertions.assertTrue(arena.isEmpty(pacmanController.getPacmanPosition().getDown()));
    }

    @Test
    void verifyActionNotPossible() {
        pacmanController.movePacmanUp();
        pacmanController.movePacmanLeft();
        action = GUI.ACTION.LEFT;

        Assertions.assertFalse(arena.isEmpty(pacmanController.getPacmanPosition().getLeft()));
    }
}
