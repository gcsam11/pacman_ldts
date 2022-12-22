package com.aor.pacman.states;

import com.aor.pacman.controller.Controller;
import com.aor.pacman.controller.menu.MenuController;
import com.aor.pacman.model.menu.Menu;
import com.aor.pacman.viewer.Viewer;
import com.aor.pacman.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
