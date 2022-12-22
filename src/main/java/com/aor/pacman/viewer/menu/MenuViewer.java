package com.aor.pacman.viewer.menu;

import com.aor.pacman.gui.GUI;
import com.aor.pacman.model.Position;
import com.aor.pacman.model.menu.Menu;
import com.aor.pacman.viewer.Viewer;

import java.io.IOException;
import java.util.Objects;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.clear();

        String white = "#FFFFFF";
        String yellow = "#FFD700";
        int nameHeight = 5;
        if(getModel().getMessage() != null) {
            gui.drawText(new Position(5,5), getModel().getMessage(), white);
            nameHeight += 2;
        }
        gui.drawText(new Position(12, nameHeight), getModel().getName(), white);

        callEqualChecker(gui, white, yellow);

        gui.refresh();
        if (Objects.equals(getModel().getReference(), "QuitMenu")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void callEqualChecker(GUI gui, String white, String yellow) {
        int i;
        for (i = 0; i < getModel().getNumberEntriesS(); i++) {
            int widthS = 28/2- getModel().getEntryS(i).length()/2;
            gui.drawText(new Position(widthS, 8 + i), getModel().getEntryS(i), getModel().isSelected(i) ? yellow : white);
        }
        for (int j = 0; j < getModel().getNumberEntriesN(); j++) {
            int widthN = 28/2- getModel().getEntryN(j).length()/2;
            equalChecker(gui, white, yellow, i, j, widthN);
        }
    }

    public void equalChecker(GUI gui, String white, String yellow, int i, int j, int widthN) {
        if (Objects.equals(getModel().getReference(), "QuitMenu")) {
            gui.drawText(new Position(widthN, 9+i+j), getModel().getEntryN(j), yellow);
        }
        else if (Objects.equals(getModel().getReference(), "FailedLevelMenu")) {
            charAtChecker(gui, white, yellow, i, j, widthN);
        }
        else {
            gui.drawText(new Position(widthN, 9+i+j), getModel().getEntryN(j), white);
        }
    }

    public void charAtChecker(GUI gui, String white, String yellow, int i, int j, int widthN) {
        if (j >= 18) {
            gui.drawText(new Position(widthN, 9+i+j), getModel().getEntryN(j), yellow);
        } else {
            for (int n = 0; n < getModel().getEntryN(j).length(); n++) {
                char ch = getModel().getEntryN(j).charAt(n);
                if (ch == '-') {
                    gui.drawText(new Position(5+n, 11+j), "o", yellow);
                }
                else if (ch == 'o') {
                    gui.drawText(new Position(5+n, 11+j), "o", white);
                }
            }
        }
    }
}
