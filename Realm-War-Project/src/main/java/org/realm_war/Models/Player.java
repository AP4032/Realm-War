package org.realm_war.Models;

import java.util.ArrayList;
import java.util.List;

import org.realm_war.Models.structure.classes.Structure;

public class Player {
    private final String name;
    private int score;
    private List<Structure> structures;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        structures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void addStructure(Structure s){ structures.add(s); }

}
