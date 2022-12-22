package com.aor.pacman.model.game;

import java.util.Arrays;
import java.util.List;

public class Pause {
    private final List<String> entries;

    public Pause() {
        this.entries = Arrays.asList("Pause [P]");
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return  0 == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
