package wormgame;

import wormgame.domain.Piece;
import wormgame.domain.Worm;

public class Main {

    public static void main(String[] args) {
        Worm m = new Worm(5, 5, Direction.UP);
        m.move();
        m.move();
        m.grow();
        m.move();
        m.move();
        m.setDirection(Direction.RIGHT);
        m.grow();
        m.move();
        m.move();
        m.setDirection(Direction.DOWN);
        m.grow();
        m.move();
        m.grow();
        m.move();
        m.move();
        m.getPieces();
        //m.runsInto(new Piece(5, 3));
        System.out.println(m.runsInto(new Piece(5, 3)));
        
        
//        WormGame game = new WormGame(20, 20);
//
//        UserInterface ui = new UserInterface(game, 20);
//        SwingUtilities.invokeLater(ui);
//
//        while (ui.getUpdatable() == null) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                System.out.println("The drawing board hasn't been created yet.");
//            }
//        }
//
//        game.setUpdatable(ui.getUpdatable());
//        game.start();
    }
}
