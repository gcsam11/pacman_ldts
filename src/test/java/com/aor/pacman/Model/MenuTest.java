package com.aor.pacman.model;

import com.aor.pacman.model.menu.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {
    Menu menu;

    @Test
    void endMenu() {
        menu = new EndMenuBuilder().createMenu();

        Assertions.assertEquals("EndMenu", menu.getReference());
    }

    @Test
    void failedLevelMenu() {
        menu = new FailedLevelMenuBuilder().createMenu();

        Assertions.assertEquals("FailedLevelMenu", menu.getReference());
    }

    @Test
    void nextLevelMenu() {
        menu = new NextLevelMenuBuilder(0, 0).createMenu();

        Assertions.assertEquals("NextLevelMenu", menu.getReference());
    }

    @Test
    void quitMenu() {
        menu = new QuitMenuBuilder().createMenu();

        Assertions.assertEquals("QuitMenu", menu.getReference());
    }

    @Test
    void startMenu() {
        menu = new StartMenuBuilder().createMenu();

        Assertions.assertEquals("StartMenu", menu.getReference());
    }
}
