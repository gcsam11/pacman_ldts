package com.aor.pacman.model;

import com.aor.pacman.model.game.elements.Coin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CoinTest {
    List<Coin> coins;

    @BeforeEach
    void init() {
        coins = new ArrayList<>();
        coins.add(new Coin(1, 1, false));
        coins.add(new Coin(2, 2, true));
    }

    @Test
    void powerUp() {
        Assertions.assertFalse(coins.get(0).getPowerUp());
    }

    @Test
    void changePowerUp() {
        coins.get(0).setPowerUp(true);

        Assertions.assertTrue(coins.get(0).getPowerUp());
    }
}
