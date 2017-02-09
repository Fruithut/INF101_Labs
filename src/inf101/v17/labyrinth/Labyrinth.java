package inf101.v17.labyrinth;

import inf101.v17.datastructures.IGrid;
import java.awt.*;

public class Labyrinth implements ILabyrinth {

    private int height, width, xPlayer, yPlayer,
            totalGold = 0, totalMonsters = 0, players = 0, playerGold = 0, hitPoints = 0;

    private boolean isPlaying;
    private IGrid<LabyrinthTile> tiles;

    public Labyrinth(IGrid<LabyrinthTile> tiles) {
        for (int i = 0; i < tiles.getWidth(); i++) {
            for (int j = 0; j < tiles.getHeight(); j++) {
                if (tiles.get(i,j).equals(LabyrinthTile.PLAYER)) {
                    if (players < 1) {
                        this.xPlayer = i;
                        this.yPlayer = j;
                        players++;
                    } else {
                        throw new IllegalArgumentException("Too many players!");
                    }
                } else if (tiles.get(i,j).equals(LabyrinthTile.GOLD)) {
                    totalGold++;
                } else if (tiles.get(i,j).equals(LabyrinthTile.MONSTER)) {
                    totalMonsters++;
                }
            }
        }
        if (players > 0) {
            this.tiles = tiles.copy();
            this.height = tiles.getHeight();
            this.width = tiles.getWidth();
            this.isPlaying = true;
            this.hitPoints = 100;
        } else {
            throw new IllegalArgumentException("No players!");
        }
    }

    @Override
    public LabyrinthTile getCell(int x, int y) {
        return tiles.get(x, y);
    }

    @Override
    public Color getColor(int x, int y) {
        return getCell(x, y).getColor();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getPlayerGold() {
        return playerGold;
    }

    @Override
    public int getPlayerHitPoints() {
        return hitPoints;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public boolean isPlaying() {
        return true;
    }

    @Override
    public void movePlayer(Direction dir) throws MovePlayerException {
        if (playerCanGo(dir)) {
            switch (dir) {
                case NORTH: if (tiles.get(xPlayer,yPlayer+1).equals(LabyrinthTile.GOLD)) {playerGold++;}
                            tiles.set(xPlayer ,yPlayer+1, LabyrinthTile.PLAYER);
                            tiles.set(xPlayer,yPlayer, LabyrinthTile.OPEN);
                            this.yPlayer = yPlayer+1;
                            break;
                case WEST:  if (tiles.get(xPlayer-1,yPlayer).equals(LabyrinthTile.GOLD)) {playerGold++;}
                            tiles.set(xPlayer-1,yPlayer, LabyrinthTile.PLAYER);
                            tiles.set(xPlayer,yPlayer, LabyrinthTile.OPEN);
                            this.xPlayer = xPlayer-1;
                            break;
                case EAST:  if (tiles.get(xPlayer+1,yPlayer).equals(LabyrinthTile.GOLD)) {playerGold++;}
                            tiles.set(xPlayer+1,yPlayer, LabyrinthTile.PLAYER);
                            tiles.set(xPlayer,yPlayer, LabyrinthTile.OPEN);
                            this.xPlayer = xPlayer+1;
                            break;
                case SOUTH: if (tiles.get(xPlayer,yPlayer-1).equals(LabyrinthTile.GOLD)) {playerGold++;}
                            tiles.set(xPlayer,yPlayer-1, LabyrinthTile.PLAYER);
                            tiles.set(xPlayer,yPlayer, LabyrinthTile.OPEN);
                            this.yPlayer = yPlayer-1;
                            break;
            }
        }

    }

    @Override
    public boolean playerCanGo(Direction d) {
        switch (d) {
            case NORTH: if (tiles.get(xPlayer, yPlayer + 1) != LabyrinthTile.WALL) {return true;}
                break;
            case WEST: if (tiles.get(xPlayer - 1, yPlayer) != LabyrinthTile.WALL) {return true;}
                break;
            case EAST: if (tiles.get(xPlayer + 1, yPlayer) != LabyrinthTile.WALL) {return true;}
                break;
            case SOUTH: if (tiles.get(xPlayer, yPlayer - 1) != LabyrinthTile.WALL) {return true;}
                break;
        }
        return false;
    }

}
