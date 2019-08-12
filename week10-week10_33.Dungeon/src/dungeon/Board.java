package dungeon;

public class Board {
    private int length, height;
    
    public Board(int length, int height) {
        this.length = length;
        this.height = height;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getHeight() {
        return height;
    }
}
