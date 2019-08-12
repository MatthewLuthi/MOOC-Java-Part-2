package dungeon;

import entities.Vampire;

public class Main {

    public static void main(String[] args) {
        //new Dungeon(10,10,5,14,true).run();
        new Dungeon(5,5,3,14,false).run();
        /*
        for (int i = 0; i < 100; i++) {
            Dungeon dungeon = new Dungeon(5, 5, 3, 14, false);
            for (Vampire vampire : dungeon.getVampires()) {
                
            }
        }
        */
    }
}

class xy {
    protected int x, y;
    
    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
