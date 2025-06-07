package org.realm_war.Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.realm_war.Models.blocks.Block;
import org.realm_war.Models.blocks.EmptyBlock;
import org.realm_war.Models.blocks.ForestBlock;
import org.realm_war.Models.blocks.VoidBlock;
import org.realm_war.Models.structure.classes.Structure;
import org.realm_war.Models.structure.classes.TownHall;
import org.realm_war.Models.units.Unit;
import org.realm_war.Utilities.Constants;
import org.realm_war.Utilities.HelperMethods;


public class GameState {
    //Track game progress
    private int currentTurn = 0;
    private int turns = 1;
    private List<Player> players = new ArrayList<>();
    private boolean running;
    private boolean isGameOver;
    private static int gridSize = Constants.getMapSize();
    private static Block[][] mapGrid = new Block[gridSize][gridSize];
    private Unit selectedUnit;
    private Block targetBlock;

    private Color[] realmColors = new Color[] {
            new Color(183, 65, 14),   // Rust
            new Color(205, 133, 63),  // Peru
            new Color(218, 165, 32),  // Goldenrod
            new Color(85, 107, 47)    // Dark Moss Green
    };

    private static List<Realm> realms = new ArrayList<>();

    public static List<Unit> getAllUnits() {
        List<Unit> allUnits = new ArrayList<>();
        for (Realm realm : realms) {
            allUnits.addAll(realm.getUnits());
        }
        return allUnits;
    }

    public static void addRealm(Realm realm) {
        realms.add(realm);
    }

    public static Realm getRealmByRealmID(int RealmID) {
        for (Realm realm : realms) {
            if (realm.getID() == RealmID) {
                return realm;
            }
        }
        return null;
    }

    public static List<Realm> getRealm() {
        return realms;
    }

    //Turn management
    public void nextTurn() {
        if (players.isEmpty()) return;
        this.currentTurn = (currentTurn + 1) % players.size();
        for (Realm realm : realms) {
            realm.updateResources();
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentTurn);
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isGameOver() {
        int realmsWithTownHall = 0;
        for (Realm realm : realms) {
            boolean hasTownHall = realm.getStructures().stream()
                    .anyMatch(s -> s instanceof TownHall && !s.isDestroyed());
            if (hasTownHall) {
                realmsWithTownHall++;
            }
        }
        return realmsWithTownHall <= 1;
    }

    public Realm getWinner() {
        if (!isGameOver()) return null;

        for (Realm realm : realms) {
            boolean hasTownHall = realm.getStructures().stream()
                    .anyMatch(s -> s instanceof TownHall && !s.isDestroyed());
            if (hasTownHall) {
                return realm; // Winner
            }
        }
        return null; // In case all TownHalls are destroyed simultaneously
    }

    //Map Management
    public static void mapInitializer() {
        mapGrid = new Block[gridSize][gridSize];  // ✅ initialize the array

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                mapGrid[i][j] = new EmptyBlock(new Position(i, j));
            }
        }

        // Fill borders with VoidBlocks
        for (int i = 0; i < gridSize; i++) {
            mapGrid[i][0] = new VoidBlock(new Position(i, 0));
            mapGrid[i][gridSize - 1] = new VoidBlock(new Position(i, gridSize - 1));
        }
        for (int j = 0; j < gridSize; j++) {
            mapGrid[0][j] = new VoidBlock(new Position(0, j));
            mapGrid[gridSize - 1][j] = new VoidBlock(new Position(gridSize - 1, j));
        }
    }

    public void initializeTownHalls() {
        Position[] positions = {
                new Position(1, 1),
                new Position(gridSize - 2, gridSize - 2),
                new Position(1, gridSize - 2),
                new Position(gridSize - 2, 1),
        };

        for (int i = 0; i < players.size(); i++) {
            Realm realm = realms.get(i);
            Position pos = positions[i];

            int goldProduction = 10;
            int foodProduction = 5;
            int maxLevel = 5;
            int durability = 100;
            int maintenance = 2;
            int kingdomId = realm.getID();

            // Create base block and town hall structure
            Block baseBlock = new EmptyBlock(pos);
            baseBlock.setStructure(null);

            TownHall townHall = new TownHall(
                    goldProduction, foodProduction,
                    maxLevel, durability, maintenance,
                    pos, baseBlock, kingdomId
            );

            // Set structure and owner info on base block
            baseBlock.setStructure(townHall);
            baseBlock.setOwnerID(kingdomId);
            baseBlock.setOwnerColor(realm.getRealmColor());

            mapGrid[pos.getX()][pos.getY()] = baseBlock;

            // Claim surrounding territory within radius 2 (circle)
            for (int dx = -2; dx <= 2; dx++) {
                for (int dy = -2; dy <= 2; dy++) {
                    int nx = pos.getX() + dx;
                    int ny = pos.getY() + dy;

                    // Check boundaries
                    if (nx >= 0 && ny >= 0 && nx < gridSize && ny < gridSize) {
                        // Euclidean distance to keep circular territory
                        double distance = Math.sqrt(dx * dx + dy * dy);
                        if (distance <= 2) {
                            mapGrid[nx][ny].setOwnerID(kingdomId);
                            mapGrid[nx][ny].setOwnerColor(realm.getRealmColor());
                        }
                    }
                }
            }

            realm.setTownHall(townHall);
            realm.getStructures().add(townHall);
        }
    }



    public void setupGame() {
        // Initialize the grid
        mapInitializer();

        // Place forests & void blocks
        blockPlacer();

        // Create Realms for each Player and add them to the realm list
        realms.clear();  // Clear any previous realms if restarting
        for (Player player : players) {
            Realm realm = new Realm(HelperMethods.idGenerator());
            addRealm(realm);
        }
        for (int i = 0; i < realms.size() ;i++){
            Realm realm = realms.get(i);
            realm.setRealmColor(realmColors[i%realms.size()]);
        }

        // Place two Town Halls (one per realm)
        initializeTownHalls();

        // Set current player and turn info
        currentTurn = 0;
        turns = 1;
    }

    public void updateMap(List<Realm> realms) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                mapGrid[i][j] = new EmptyBlock(new Position(i, j));
            }
        }
        for (Realm realm : realms) {
            List<Structure> structures = realm.getStructures();
            List<Unit> units = realm.getUnits();

            for (Structure s : structures) {
                Position pos = s.getPosition();
                mapGrid[pos.getX()][pos.getY()] = s.getBaseBlock();
            }
            for (Unit u : units) {
                Position pos = u.getPosition();
                mapGrid[pos.getX()][pos.getY()].setUnit(u);
            }
        }
    }

    //Call this after initializing the grid
    public static void blockPlacer() {
        Random rand = new Random();
        for (int i = 80; i >= 0; i--) {
            int x = rand.nextInt(1, mapGrid.length - 2);
            int y = rand.nextInt(1, mapGrid[0].length - 2);
            mapGrid[x][y] = new ForestBlock(new Position(x, y));
        }
        for (int i = 30; i >= 0; i--) {
            int x = rand.nextInt(1, mapGrid.length - 2);
            int y = rand.nextInt(1, mapGrid[0].length - 2);
            mapGrid[x][y] = new VoidBlock(new Position(x, y));
        }
    }

    public static Block[][] getMapGrid() {
        return mapGrid;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public List<Realm> getRealms() {
        return realms;
    }

    public int getTurnNumber() {
        return turns;
    }

    public Realm getCurrentRealm() {
        return realms.get(currentTurn);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player newPlayer) {
        this.players.add(newPlayer);
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Block getTargetBlock() {
        return targetBlock;
    }

    public void setSelectedUnit(Unit unit) {
        this.selectedUnit = unit;
    }

    public void setTargetBlock(Block block) {
        this.targetBlock = block;
    }

    //Interaction Helpers
    public Structure getStructureAt(Position pos) {
        return mapGrid[pos.getX()][pos.getY()].getStructure();
    }

    public Unit getUnitAt(Position pos) {
        return mapGrid[pos.getX()][pos.getY()].getUnit();
    }

    public Color[] getRealmColors() {
        return realmColors;
    }

    public Block getBlockAt(Position pos) {
        int x = pos.getX();
        int y = pos.getY();
        if (x < 0 || y < 0 || x >= mapGrid.length || y >= mapGrid[0].length) return null;
        return mapGrid[x][y];
    }

    public void setBlockAt(Position pos, Block block) {
        mapGrid[pos.getX()][pos.getY()] = block;
    }

    public boolean isOccupied(Position pos) {
        return mapGrid[pos.getX()][pos.getY()].getStructure().getBaseBlock().isOccupied();
    }

}
