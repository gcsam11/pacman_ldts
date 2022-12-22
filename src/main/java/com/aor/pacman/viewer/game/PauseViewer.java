package com.aor.pacman.viewer.game;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.game.Pause;
import com.aor.pacman.viewer.Viewer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PauseViewer extends Viewer<Pause> {
    public PauseViewer(Pause pause) {
        super(pause);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.clear();

        String color = "#FFFFFF";
        gui.drawText(new Position(5, 5), "", color);

        drawElementsHelper(gui, color);

        List<String> pacmanText = Arrays.asList("      oooo     ",
                "    oo----oo   ",
                "   o--------o  ",
                "  o----------o ",
                " o------------o",
                " o----------oo ",
                "o--------ooo   ",
                "o-----ooo      ",
                "o-------o      ",
                "o--------ooo   ",
                " o----------oo ",
                " o------------o",
                "  o----------o ",
                "   o--------o  ",
                "    oo----oo   ",
                "      oooo     ");

        for (int i = 0; i < pacmanText.size(); i++) {
            charCheck(gui, color, pacmanText, i);
        }

        gui.refresh();
    }

    public void charCheck(GUI gui, String color, List<String> pacmanText, int i) {
        for (int j = 0; j < pacmanText.get(i).length(); j++) {
            char ch = pacmanText.get(i).charAt(j);
            if (ch == '-') {
                gui.drawText(new Position(7+j, 12+i), "o", "#FFD700");
            }
            else if (ch == 'o') {
                gui.drawText(new Position(7+j, 12+i), "o", color);
            }
        }
    }

    public void drawElementsHelper(GUI gui, String color) {
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : color);
    }
}