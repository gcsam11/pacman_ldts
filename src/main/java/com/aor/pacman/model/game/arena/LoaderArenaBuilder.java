package com.aor.pacman.model.game.arena;

import com.aor.pacman.model.game.elements.Coin;
import com.aor.pacman.model.game.elements.Pacman;
import com.aor.pacman.model.game.elements.Monster;
import com.aor.pacman.model.game.elements.Wall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException,NullPointerException {
        this.level = level;
        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    public Arena createArena(){
        Arena arena = new Arena(level, getWidth(), getHeight());

        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setCoins(createCoins());
        arena.setPacmanObservers();

        return arena;
    }
    @Override
    public int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width-2;
    }

    @Override
    public int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            addWalls(walls, y, line);
        }

        return walls;
    }

    public void addWalls(List<Wall> walls, int y, String line) {
        for (int x = 0; x < line.length(); x++)
            if (line.charAt(x) == '#') walls.add(new Wall(x, y));
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            addMonsters(monsters, y, line);
        }

        return monsters;
    }

    public void addMonsters(List<Monster> monsters, int y, String line) {
        for (int x = 0; x < line.length(); x++)
            if (line.charAt(x) == 'M') monsters.add(new Monster(x, y));
    }

    @Override
    protected Pacman createPacman() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'C') return new Pacman(x, y);
        }
        return null;
    }

    @Override
    protected List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();
        for(int y = 0; y < lines.size(); y++){
            String line = lines.get(y);
            addCoins(coins, y, line);
        }
        return coins;
    }

    public void addCoins(List<Coin> coins, int y, String line) {
        for(int x = 0; x < line.length(); x++){
            if(line.charAt(x) == ' ') coins.add(new Coin(x,y));
            if(line.charAt(x) == '*') coins.add(new Coin(x,y,true));
        }
    }
}