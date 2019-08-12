package dungeon;

import entities.Entity;
import helpers.GetRandom;
import entities.Player;
import entities.Vampire;
import helpers.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Dungeon {

    private Board board;
    private Player player;
    private List<Vampire> vampires;
    private int moves;
    private boolean vampiresMove;
    private Scanner scanner;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        scanner = new Scanner(System.in);
        this.moves = moves;
        this.vampiresMove = vampiresMove;

        board = new Board(length, height);
        player = new Player(board);
        this.vampires = new ArrayList<Vampire>();
        spawnVampires(vampires);
    }

    private void spawnVampires(int nVampires) {
        for (int i = 0; i < nVampires; i++) {
            int xPos = GetRandom.generate(1, board.getLength()); //Make sure no vampire can spawn on top of player
            int yPos = GetRandom.generate(1, board.getHeight());
            Vampire validVampire = new Vampire(xPos, yPos, i, board);
            
            if (!vampires.isEmpty()) {
                boolean unvalidSpawn = true;
                while (unvalidSpawn) {
                    xPos = GetRandom.generate(1, board.getLength()); 
                    yPos = GetRandom.generate(1, board.getHeight());
                    validVampire = new Vampire(xPos, yPos, i, board);
                    
                    List<Boolean> noCollisions = new ArrayList<Boolean>(vampires.size());
                    for (Vampire vampire : vampires) {
                        if (vampire.collision(validVampire)) {
                            noCollisions.add(false);
                        } else {
                            noCollisions.add(true);
                        }
                    }
                    
                    if (!noCollisions.contains(false)) {
                        unvalidSpawn = false;
                    }
                }

                vampires.add(validVampire);
            } else {
                vampires.add(new Vampire(xPos, yPos, i, board));
            }
        }
    }

    public void run() {
        while (moves > 0) {
            if (vampires.isEmpty()) {
                break;
            }

            System.out.println(moves + "\n");
            printEntityPos();
            printDungeon();

            readPlayerMove();
            if (vampiresMove) {
                handleVampireMove();
            }

            updateVampireList();
            moves--;
        }

        if (vampires.isEmpty()) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }

    private void readPlayerMove() {
        String moves = scanner.nextLine();
        moves = StringUtils.formatWord(moves);

        for (int i = 0, n = moves.length(); i < n; i++) {
            char letter = moves.charAt(i);
            handlePlayerMove(letter);
        }

        player.setNumMoves(moves.length());
    }

    private void updateVampireList() {
        List<Vampire> deadVampires = new ArrayList<Vampire>();

        for (Vampire vampire : vampires) {
            if (!vampire.isAlive()) {
                deadVampires.add(vampire);
            }
        }
        vampires.removeAll(deadVampires);
    }

    private void handlePlayerMove(char letter) {
        handleEntityMove(player, letter);

        for (Vampire vampire : vampires) {
            if (player.collision(vampire)) {
                vampire.setAlive(false);
            }
        }
    }

    private void handleEntityMove(Entity entity, char letter) {
        if (letter == 'w') {
            entity.moveUp();
        } else if (letter == 'a') {
            entity.moveLeft();
        } else if (letter == 's') {
            entity.moveDown();
        } else if (letter == 'd') {
            entity.moveRight();
        }
    }

    private void handleVampireMove(Vampire vampire, char letter) {
        handleEntityMove(vampire, letter);

        for (Vampire aVampire : vampires) {
            if (vampire.collision(aVampire)) {
                reverseMove(vampire, letter);
            }
        }
    }

    private void reverseMove(Vampire vampire, char letter) {
        if (letter == 'w') {
            vampire.moveDown();
        } else if (letter == 'a') {
            vampire.moveRight();
        } else if (letter == 's') {
            vampire.moveUp();
        } else if (letter == 'd') {
            vampire.moveLeft();
        }
    }

    /**
     * Vampires move randomly, and take one step for every step a player has
     * taken
     *
     * @param nMoves The number of steps a player has taken
     */
    private void handleVampireMove() {
        char[] possibleMoves = {'w', 'a', 's', 'd'};

        for (Vampire vampire : vampires) {
            for (int i = 0; i < player.getNumMoves(); i++) {
                int rolledMove = GetRandom.generate(0, 4);
                handleVampireMove(vampire, possibleMoves[rolledMove]);
            }
        }
    }

    private void printEntityPos() {
        System.out.println("@ " + player.getXPos() + " " + player.getYPos());

        for (Vampire vampire : vampires) {
            System.out.println("v " + vampire.getXPos() + " " + player.getYPos());
        }
        System.out.println();
    }

    private boolean printPlayer(int x, int y) {
        return ((player.getXPos() == x) && (player.getYPos() == y));
    }

    private boolean printVampire(int x, int y) {
        for (Vampire vampire : vampires) {
            if (vampire.getXPos() == x && vampire.getYPos() == y) {
                return true;
            }
        }

        return false;
    }

    private void printDungeon() {
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getLength(); x++) {
                if (printPlayer(x, y)) {
                    System.out.print("@");
                } else if (printVampire(x, y)) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public Collection<Vampire> getVampires() {
        return vampires;
    }
}
