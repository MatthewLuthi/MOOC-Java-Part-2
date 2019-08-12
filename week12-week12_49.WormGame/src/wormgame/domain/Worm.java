package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

public class Worm {
    
    private Direction direction;
    private List<Piece> worm;
    private boolean grow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        direction = originalDirection;
        worm = new ArrayList<Piece>();
        worm.add(new Piece(originalX, originalY));
        grow = false;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        direction = dir;
    }
    
    public int getLength() {
        return worm.size();
    }
    
    public List<Piece> getPieces() {
        return worm;
    }
    
    public Piece getWormHead() {
        return worm.get(getLength() - 1);
    }
    
    public void move() {      
        int newXPos = getWormHead().getX();
        int newYPos = getWormHead().getY();
        
        if (direction == Direction.DOWN) {
            newYPos++;
        } else if (direction == Direction.UP) {
            newYPos--;
        } else if (direction == Direction.LEFT) {
            newXPos--;
        } else {
            newXPos++;
        }
        
        if (getLength() > 2 && !grow) {
            worm.remove(0);
        }
        
        if (grow) {
            grow = false;
        }
        
        worm.add(new Piece(newXPos, newYPos));
    }
    
    public void grow() {
        grow = true;  
    }
    
    public boolean runsInto(Piece piece) {
        for (Piece wormPiece : worm) {
            if (wormPiece.getX() == piece.getX() && wormPiece.getY() == piece.getY()) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean runsIntoItself() {
        for (Piece piece : worm) {
            if (piece.equals(getWormHead())) {
                continue;
            }
            
            if (getWormHead().getX() == piece.getX() && 
                    getWormHead().getY() == piece.getY()) {
                return true;
            }
        }
        
        return false;
    }
}
