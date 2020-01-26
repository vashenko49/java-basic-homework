import java.util.Random;
import java.util.Scanner;

public class Battle {
    private final int LENGTH_SELECTED_COORDINATES = 10;
    private final int LENGTH_GAME_MAP = 6;
    private final int LENGTH_TARGET = 3;

    private boolean isChitModeGame = false;
    private int countTargetHit = 0;
    private String gameMap[][];
    private int selectedCoordinates[][];
    private int indexSelectedCoordinates = 0;
    private int targetCoordinates[][];
    private Random random;
    private Scanner scanner;

    public Battle(boolean isChitModeGame) {
        this.isChitModeGame = isChitModeGame;
        selectedCoordinates = new int[LENGTH_SELECTED_COORDINATES][2];
        targetCoordinates = new int[LENGTH_TARGET][2];
        random = new Random();
        scanner = new Scanner(System.in);
        gameMap = new String[LENGTH_GAME_MAP][LENGTH_GAME_MAP];
        initGameMap();
        initTargetCoordinates();
        if (isChitModeGame) {
            activateChitMode();
        }
    }

    private void activateChitMode() {
        for (int i = 0; i < LENGTH_TARGET; i++) {
            gameMap[targetCoordinates[i][0]][targetCoordinates[i][1]] = "t";
        }
    }

    private void initGameMap() {
        for (int i = 0; i < LENGTH_GAME_MAP; i++) {
            for (int j = 0; j < LENGTH_GAME_MAP; j++) {
                if (i == 0) {
                    gameMap[i][j] = Integer.toString(j);
                } else if (j == 0) {
                    gameMap[i][j] = Integer.toString(i);
                } else {
                    gameMap[i][j] = "-";
                }
            }
        }
    }

    private void initTargetCoordinates() {
        targetCoordinates[0][0] = random.nextInt(LENGTH_GAME_MAP - 2) + 1;
        targetCoordinates[0][1] = random.nextInt(LENGTH_GAME_MAP - 2) + 1;

        boolean isVertical = random.nextBoolean();

        for (int i = 1; i < LENGTH_TARGET; i++) {
            targetCoordinates[i][0] = !isVertical ? targetCoordinates[i - 1][0] : targetCoordinates[i - 1][0] + 1 > LENGTH_GAME_MAP - 1 ? 1 : targetCoordinates[i - 1][0] + 1;
            targetCoordinates[i][1] = isVertical ? targetCoordinates[i - 1][1] : targetCoordinates[i - 1][1] + 1 > LENGTH_GAME_MAP - 1 ? 1 : targetCoordinates[i - 1][1] + 1;
        }
    }

    private void printGameMap() {
        for (int i = 0; i < LENGTH_GAME_MAP; i++) {
            for (int j = 0; j < LENGTH_GAME_MAP; j++) {
                System.out.print(gameMap[i][j] + " | ");
            }
            System.out.println();
        }
    }

    private void selectCoordinate(int x, int y) {
        boolean isHit = false;
        for (int i = 0; i < selectedCoordinates.length; i++) {
            if (selectedCoordinates[i][0] == x && selectedCoordinates[i][1] == y) {
                System.out.println("This coordinate has already been entered");
                return;
            }
        }

        //if the array is filled more than 80% expand it
        if (selectedCoordinates.length * 0.8 < indexSelectedCoordinates) {
            expandSelectedCoordinatesArray();
        }

        selectedCoordinates[indexSelectedCoordinates][0] = x;
        selectedCoordinates[indexSelectedCoordinates][1] = y;
        indexSelectedCoordinates++;


        for (int i = 0; i < LENGTH_TARGET; i++) {
            if (targetCoordinates[i][0] == x && targetCoordinates[i][1] == y) {
                countTargetHit++;
                isHit= true;
            }
        }
        gameMap[x][y] = isHit?"x":"*";
    }

    private void expandSelectedCoordinatesArray() {
        int[][] newArray = new int[LENGTH_SELECTED_COORDINATES * 2][2];
        for (int i = 0; i < selectedCoordinates.length; i++) {
            System.arraycopy(selectedCoordinates[i], 0, newArray[i], 0, selectedCoordinates[i].length);
        }
        selectedCoordinates = newArray;
    }

    private boolean isNumber(String value) {
        return value.matches("[-+]?\\d+");
    }

    private int EnterCoordinate(String message, int minNumber, int maxNumber) {
        boolean isNotEnter = true;
        int variable = 0;

        while (isNotEnter) {
            System.out.print(message);
            String enteredData = scanner.next();
            if (isNumber(enteredData)) {
                variable = Integer.parseInt(enteredData);
                if (variable <= maxNumber && variable >= minNumber) {
                    isNotEnter = false;
                } else {
                    System.out.println("Please enter a number between " + minNumber + " to " + maxNumber);
                }
            } else {
                System.out.println("Please enter a number");
            }
        }

        return variable;
    }

    public void startGame() {
        System.out.println("All set. Get ready to rumble!");
        printGameMap();
        while (countTargetHit < LENGTH_TARGET) {
            int x = EnterCoordinate("Enter first coordinate: ", 1, LENGTH_GAME_MAP - 1);
            int y = EnterCoordinate("Enter second coordinate: ", 1, LENGTH_GAME_MAP - 1);
            selectCoordinate(x, y);
            printGameMap();
        }
        System.out.println("You have won!");
        scanner.close();
    }

}
