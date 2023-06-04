import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
            board[x + i][y] = length;

        } else {
            board[x][y + i] = length;
        }
    }
}

private void play() {
    Scanner sc = new Scanner(System.in);
    int shots = 0;
    int hits = 0;
    int points = 0;
    List<String> sunkenShips = new ArrayList<>();
    while(hits < 5 && shots < 10) {
        int x,y = 0;
        System.out.println("Enter x and y coordinates seperated by a comma (1-10): ");
        try {
            String input = sc.nextLine();
            String[] coordinates = input.split(",");
            x = Integer.parseInt(coordinates[0]) - 1;
            y = Integer.parseInt(coordinates[1]) - 1;
        } catch (Exception e) {
            System.out.println("Invalid input");
            continue;
        }
        
        if (board[x][y] > 0) {
            System.out.println("Hit!");
            points += board[x][y];
            switch (board[x][y]) {
                case 5:
                    System.out.println("Congratulations ! You sunk the Aircraft Carrier! It was worth 5 points!");
                    sunkenShips.add(SHIP_NAMES[0]);
                    break;
                case 4:
                    System.out.println("Congratulations ! You sunk the Battleship! It was worth 4 points!");
                    sunkenShips.add(SHIP_NAMES[1]);
                    break;
                case 3: 
                    System.out.println("Congratulations ! You sunk the Submarine! It was worth 3 points!");
                    sunkenShips.add(SHIP_NAMES[2]);
                    break;
                case 2: 
                    System.out.println("Congratulations ! You sunk the Destroyer! It was worth 2 points!");
                    sunkenShips.add(SHIP_NAMES[3]);
                    break;
                case 1: 
                    System.out.println("Congratulations ! You sunk the Patrol Boat! It was worth 1 points!");
                    sunkenShips.add(SHIP_NAMES[4]);
                    break;
                default:
                    break;
            }
            board[x][y] = -1;
            hits++;
            shots++;
        } else if (board[x][y] == -1) {
            System.out.println("You have already hit this location ! Cannot shoot here again.");
        } else {
            System.out.println("Miss!");
            shots++;
        }
    }

    if (hits == 5) {
        System.out.println("You won! You sunk all the ships! You scored 15 points !");
    } else {
        System.out.println("You lost :( You scored " + points + " points!");
        System.out.println("You sunk the following ship(s): ");
        for (String ship : sunkenShips) {
            System.out.println(ship);
        }
    }
}

public static void main(String[] args) {
    Battleships game = new Battleships();
    game.placeFleet();
    game.play();
}

}
