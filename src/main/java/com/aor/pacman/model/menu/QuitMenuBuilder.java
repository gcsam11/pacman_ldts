package com.aor.pacman.model.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuitMenuBuilder extends MenuBuilder{
    @Override
    protected List<String> createEntriesS() {
        return Collections.emptyList();
    }

    @Override
    protected List<String> createEntriesN() {
        return Arrays.asList("Thank's for playing!!!", "", "Leaving...");
    }

    @Override
    protected String createMessage() {
        return null;
    }

    @Override
    protected String getReference() {
        return "QuitMenu";
    }
}
