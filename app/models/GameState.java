package models;

import java.util.ArrayList;
import java.util.List;
import models.blocks.Block;
import models.blocks.VoidBlock;
import models.blocks.ForestBlock;
import models.blocks.EmptyBlock;
import models.structures.TownHall;
import java.io.*;

public class GameState {
    private int currentPlayerTurn;
    private List<Kingdom> kingdoms;
    private Block[][] gameMap;
    private int turnNumber;
    private boolean running;

    public GameState(int mapWidth, int mapHeight, int playerCount) {
        this.kingdoms = new ArrayList<>();
        this.gameMap = new Block[mapWidth][mapHeight];
        this.currentPlayerTurn = 0;
        this.turnNumber = 1;
        
        initializeMap(mapWidth, mapHeight);
        initializeKingdoms(playerCount);
    }

    private void initializeMap(int width, int height) {
        // Initialize the game map with different block types
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Simple map generation logic
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    gameMap[x][y] = new VoidBlock(new Position(x, y));
                } else if (Math.random() < 0.2) {
                    gameMap[x][y] = new ForestBlock(new Position(x, y));
                } else {
                    gameMap[x][y] = new EmptyBlock(new Position(x, y));
                }
            }
        }
    }

    private void initializeKingdoms(int playerCount) {
        // Place kingdoms at corners of the map
        int[][] startingPositions = {
            {1, 1},
            {gameMap.length - 2, gameMap[0].length - 2},
            {1, gameMap[0].length - 2},
            {gameMap.length - 2, 1}
        };
        
        for (int i = 0; i < playerCount; i++) {
            Position townHallPos = new Position(startingPositions[i][0], startingPositions[i][1]);
            Block baseBlock = gameMap[townHallPos.getX()][townHallPos.getY()];
            TownHall townHall = new TownHall(townHallPos, baseBlock, i + 1);
            Kingdom kingdom = new Kingdom(i + 1, townHall);
            kingdoms.add(kingdom);
            
            // Absorb surrounding blocks
            absorbSurroundingBlocks(kingdom, townHallPos);
        }
    }

    private void absorbSurroundingBlocks(Kingdom kingdom, Position center) {
        // Simple absorption logic - absorb adjacent blocks
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int x = center.getX() + dx;
                int y = center.getY() + dy;
                
                if (x >= 0 && x < gameMap.length && y >= 0 && y < gameMap[0].length) {
                    Block block = gameMap[x][y];
                    if (!(block instanceof VoidBlock)) {
                        kingdom.absorbBlock(block);
                    }
                }
            }
        }
    }

    public void nextTurn() {
        // Update resources for all kingdoms
        for (Kingdom kingdom : kingdoms) {
            kingdom.updateResources();
        }

        // Move to the next player's turn
        currentPlayerTurn = (currentPlayerTurn + 1) % kingdoms.size();
        if (currentPlayerTurn == 0) {
            turnNumber++;
        }

        // Start the new player's turn
        kingdoms.get(currentPlayerTurn).startTurn();
    }
    
    // Getters and setters
    public int getCurrentPlayerTurn() { return currentPlayerTurn; }
    public List<Kingdom> getKingdoms() { return kingdoms; }
    public Block[][] getGameMap() { return gameMap; }
    public int getTurnNumber() { return turnNumber; }
    public Kingdom getCurrentKingdom() { return kingdoms.get(currentPlayerTurn); }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    // Method to save the current game state
    public void saveGameState(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
            System.out.println("Game state saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load a game state
    public static GameState loadGameState(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            GameState gameState = (GameState) ois.readObject();
            System.out.println("Game state loaded from " + filePath);
            return gameState;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}