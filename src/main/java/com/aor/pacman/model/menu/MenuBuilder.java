package com.aor.pacman.model.menu;

import java.util.List;

public abstract class MenuBuilder {
    public Menu createMenu(){
        Menu menu = new Menu();
        menu.setName(getName());
        menu.setReference(getReference());
        menu.setMessage(createMessage());
        menu.setEntriesS(createEntriesS());
        menu.setEntriesN(createEntriesN());

        return menu;
    }
    protected abstract List<String> createEntriesS();
    protected abstract List<String> createEntriesN();
    protected String getName(){
        return "Menu";
    }
    protected abstract String getReference();
    protected abstract String createMessage();
}
