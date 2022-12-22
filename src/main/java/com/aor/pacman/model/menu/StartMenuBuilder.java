package com.aor.pacman.model.menu;

import java.util.Arrays;
import java.util.List;

public class StartMenuBuilder extends MenuBuilder{
    @Override
    protected List<String> createEntriesS() {
        return Arrays.asList("Start [S]","Quit  [Q]");
    }

    @Override
    protected List<String> createEntriesN() {
        return Arrays.asList("Commands", "", "Back  [B]", "Pause [P]");
    }

    @Override
    protected String createMessage() {
        return null;
    }

    @Override
    protected String getReference() {
        return "StartMenu";
    }
}
