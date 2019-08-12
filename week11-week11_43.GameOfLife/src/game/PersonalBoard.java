package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        boolean[][] board = getBoard();
        Random rand = new Random();

        double nRand = 0;

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                nRand = rand.nextDouble();
                if (nRand <= probabilityForEachCell) {
                    board[x][y] = true;
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (!inBounds(x, y)) {
            return false;
        }

        boolean[][] board = getBoard();
        return board[x][y];
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (!inBounds(x, y)) {
            return;
        }

        boolean[][] board = getBoard();
        board[x][y] = true;
    }

    @Override
    public void turnToDead(int x, int y) {
        if (!inBounds(x, y)) {
            return;
        }

        boolean[][] board = getBoard();
        board[x][y] = false;
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        boolean[][] board = getBoard();
        int nOfLivingCells = 0;

        if (inBounds((x - 1), (y - 1))) {
            if (board[x - 1][y - 1]) {
                nOfLivingCells++;
            }
        }

        if (inBounds((x), (y - 1))) {
            if (board[x][y - 1]) {
                nOfLivingCells++;
            }
        }

        if (inBounds((x + 1), (y - 1))) {
            if (board[x + 1][y - 1]) {
                nOfLivingCells++;
            }
        }

        if (inBounds((x - 1), (y))) {
            if (board[x - 1][y]) {
                nOfLivingCells++;
            }
        }

        if (inBounds((x + 1), (y))) {
            if (board[x + 1][y]) {
                nOfLivingCells++;
            }
        }

        if (inBounds((x - 1), (y + 1))) {
            if (board[x - 1][y + 1]) {
                nOfLivingCells++;
            }
        }

        if (inBounds((x), (y + 1))) {
            if (board[x][y + 1]) {
                nOfLivingCells++;
            }
        }

        if (inBounds((x + 1), (y + 1))) {
            if (board[x + 1][y + 1]) {
                nOfLivingCells++;
            }
        }

        return nOfLivingCells;
    }

    private boolean inBounds(int x, int y) {
        if ((x >= 0 && x < getWidth())
                && (y >= 0 && y < getHeight())) {
            return true;
        }

        return false;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2) {
            turnToDead(x, y);
        } else if (livingNeighbours > 3) {
            turnToDead(x, y);
        } 
        if (livingNeighbours == 3) {
            turnToLiving(x, y);
        }
    }
}
