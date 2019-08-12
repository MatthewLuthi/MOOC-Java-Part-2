package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable {

    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (Piece piece : wormGame.getWorm().getPieces()) {
            g.fill3DRect(piece.getX() * pieceLength, piece.getY() * pieceLength, pieceLength, pieceLength, true);
        }

        g.setColor(Color.RED);
        int xApplePos = wormGame.getApple().getX();
        int yApplePos = wormGame.getApple().getY();
        g.fillOval(xApplePos * pieceLength, yApplePos * pieceLength, pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
