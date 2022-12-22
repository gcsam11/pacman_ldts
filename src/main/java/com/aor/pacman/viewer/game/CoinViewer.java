package com.aor.pacman.viewer.game;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        char c = '.';
        String color = "#FFFFFF";
        boolean powerUp = coin.getPowerUp();
        drawCoin(coin, gui, c, color, powerUp);
    }

    public void drawCoin(Coin coin, GUI gui, char c, String color, boolean powerUp) {
        if(powerUp){
            c = '*';
            color = "#FF0000";
        }
        gui.drawCoin(coin.getPosition(),c,color);
    }
}
