package com.aor.pacman.model.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextLevelMenuBuilder extends MenuBuilder{
    private final long score;
    private final int levelPassed;
    public NextLevelMenuBuilder(long score,int levelPassed){
        this.score = score;
        this.levelPassed = levelPassed;
    }
    @Override
    protected List<String> createEntriesS() {
        return Arrays.asList("Next Level [N]", "Quit       [Q]");
    }

    @Override
    protected List<String> createEntriesN() {
        return Arrays.asList("Level " + levelPassed + " completed", "", "your score: " + score);
    }

    @Override
    protected String createMessage() {
        return null;
    }

    @Override
    protected String getReference() {
        return "NextLevelMenu";
    }
}
