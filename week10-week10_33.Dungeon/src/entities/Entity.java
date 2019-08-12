package entities;

import dungeon.Board;

public class Entity {
    private int xPos, yPos, numMoves;
    private Board board;
    
    public Entity(int xPos, int yPos, Board board) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.board = board;
        numMoves = 0;
    }
    
    public void setNumMoves(int nMoves) {
        this.numMoves = nMoves;
    }
    
    public int getNumMoves() {
        return numMoves;
    }
    
    public boolean collision(Entity entity) {
        if (!entity.equals(this)) {
            if (xPos == entity.getXPos() &&
                yPos == entity.getYPos()) {
            return true;
            }
        }
  
        return false;
    }
    
    public boolean collision(int x, int y) {
            if (xPos == x && yPos == y) {
            return true;
            }
  
        return false;
    }
    
    public void moveUp() {
        if (yPos > 0) {
            yPos--;
        }    
    }
    
    public void moveDown() {
        if (yPos < board.getHeight()-1) {
           yPos++; 
        }
    }
    
    public void moveLeft() {
        if (xPos > 0) {
            xPos--;
        }
    }
    
    public void moveRight() {
        if (xPos < board.getLength()-1) {
           xPos++; 
        }
    }
    
    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
