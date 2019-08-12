package entities;

import dungeon.Board;
import helpers.GetRandom;

public class Vampire extends Entity {
    private boolean alive;
    private int id;
    
    public Vampire(int xPos, int yPos, int id, Board board) {
        super(xPos, yPos, board);
        alive = true;
        this.id = id;
    } 
    
    public void setAlive(boolean aliveState) {
        alive = aliveState;
    }
    
    public boolean isAlive() {
        return alive;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vampire other = (Vampire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
