package com.aor.pacman.Model;

import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.arena.Arena;
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

    /*@Test
    void diffObject() {
        Assertions.assertNotEquals(new Arena(level, 10, 10), position);
    }*/

    @Test
    void emptyEquals() {
        Assertions.assertNotEquals(null, position);
    }
}
