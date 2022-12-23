package com.aor.pacman.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    Position position;

    @BeforeEach
    public void init() {
        position = new Position(4, 6);
    }

    @Test
    void Equals() {
        Assertions.assertEquals(new Position(4, 6), position);
    }

    @Test
    void diffValues() {
        Assertions.assertNotEquals(new Position(6, 7), position);
    }

    @Test
    void emptyEquals() {
        Assertions.assertNotEquals(null, position);
    }

    @Test
    void positionGetLeft() {
        Position testPosition = position.getLeft();

        Assertions.assertEquals(new Position(3, 6), testPosition);
    }

    @Test
    void positionGetRight() {
        Position testPosition = position.getRight();

        Assertions.assertEquals(new Position(5, 6), testPosition);
    }

    @Test
    void positionGetUp() {
        Position testPosition = position.getUp();

        Assertions.assertEquals(new Position(4, 5), testPosition);
    }

    @Test
    void positionGetDown() {
        Position testPosition = position.getDown();

        Assertions.assertEquals(new Position(4, 7), testPosition);
    }
}
