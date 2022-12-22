package com.aor.pacman.model.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EndMenuBuilder extends MenuBuilder{
    @Override
    protected List<String> createEntriesS() {
        return Arrays.asList("Restart [R]","Quit    [Q]");
    }

    @Override
    protected List<String> createEntriesN() {
        return Arrays.asList("You've completed", "", "all levels", "", "congratulations!");
    }

    @Override
    protected String createMessage() {
        return null;
    }

    @Override
    protected String getReference() {
        return "EndMenu";
    }
}
