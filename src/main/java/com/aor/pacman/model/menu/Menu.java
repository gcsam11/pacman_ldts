package com.aor.pacman.model.menu;

import com.aor.pacman.model.game.arena.LoaderArenaBuilder;
import com.aor.pacman.states.GameState;
import com.aor.pacman.states.State;

import java.io.IOException;
import java.util.List;

public class Menu {
    private List<String> entriesS;
    private List<String> entriesN;
    private int currentEntry = 0;
    private String message;
    private String name;
    private String reference;

    public Menu() {
        this.entriesS = List.of();
        this.entriesN = List.of();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    protected void setReference(String reference) {
        this.reference = reference;
    }

    public String getMessage() {
        return this.message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    protected void setEntriesS(List<String> entriesS) {
        this.entriesS = entriesS;
    }

    protected void setEntriesN(List<String> entriesN) {
        this.entriesN = entriesN;
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entriesS.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entriesS.size() - 1;
    }

    public String getEntryS(int i) {
        return entriesS.get(i);
    }

    public String getEntryN(int i) {
        return entriesN.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntriesS() {
        return this.entriesS.size();
    }

    public int getNumberEntriesN() {
        return this.entriesN.size();
    }

    protected int getCurrentEntry(){return this.currentEntry;}

    public void setCurrentEntry(int currentEntry) {
        this.currentEntry = currentEntry;
    }

    public GameState getNewState(int nextLevel) throws IOException,NullPointerException{
        if (this.getCurrentEntry() == 0) {
            return new GameState(new LoaderArenaBuilder(nextLevel).createArena());
        }
        return null;
    }
}
