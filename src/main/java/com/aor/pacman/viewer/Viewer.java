package com.aor.pacman.viewer;

import com.aor.pacman.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        drawElements(gui);
    }

    protected abstract void drawElements(GUI gui) throws IOException;
}
