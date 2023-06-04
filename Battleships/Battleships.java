import java.util.*;

public class Battleships {
    private static final String[] SHIP_NAMES = {
        "Aircraft Carrier",
        "Battleship",
        "Submarine",
        "Destroyer",
        "Patrol Boat"
    };

private static final int[] SHIP_LENGTHS = {5, 4, 3, 2, 1};

private int [][] board = new int [10][10];

private void placeFleet() {
    Random random = new Random();
    for (int i = 0; i < SHIP_NAMES.length; i++) {
        int x, y;
        boolean horizontal;
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
            horizontal = random.nextBoolean();
        } while (!canPlaceShip(SHIP_LENGTHS[i], x, y, horizontal));
        placeShip(SHIP_LENGTHS[i], x, y, horizontal);
    } 
}

private boolean canPlaceShip(int length, int x, int y, boolean horizontal) {
    if (horizontal && x + length > 10) {
        return false;
    }
    if (!horizontal && y + length > 10) {
        return false;
    }
    for (int i = 0; i < length; i++) {
        if (horizontal && board[x + i][y] != 0) {
            return false;
        }
        if (!horizontal && board[x][y + i] != 0) {
            return false;
        }
    }
    return true;
}

private void placeShip(int length, int x, int y, boolean horizontal) {
    for (int i = 0; i < length; i++) {
        if (horizontal) {
            board[x + i][y] = 1;
        } else {
            board[x][y + i] = 1;
        }
    }
}
}
