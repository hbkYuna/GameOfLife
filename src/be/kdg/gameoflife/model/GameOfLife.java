package be.kdg.gameoflife.model;

public class GameOfLife {

    private final int width;
    private final int height;
    private int[][] boardArray;

    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.boardArray = new int[width][height];
    }

    @Override
    public String toString() {
        StringBuilder bordString = new StringBuilder("-----------\n");
        for (int y = 0; y < height; y++) {
            bordString.append("\n-");
            for (int x = 0; x < width; x++) {
                if (this.boardArray[x][y] == 0) {
                    bordString.append(".");
                } else {
                    bordString.append("x");
                }
            }
            bordString.append("-");

        }
        bordString.append("\n\n-----------");
        return bordString.toString();
    }

    /**
     * Geef het coordinaat mee waarvan je de buren wilt tellen.
     *
     * @param x
     * @param y
     * @return int - aantal buren
     */
    public int countNeighbours(int x, int y) {
        int amountNeighbours = 0;

        // Bovenste 3 cellen
        amountNeighbours += isCoordinateOnBoardSet0(x - 1, y - 1);
        amountNeighbours += isCoordinateOnBoardSet0(x, y - 1);
        amountNeighbours += isCoordinateOnBoardSet0(x + 1, y - 1);

        // Links en rechts aanliggende cellen
        amountNeighbours += isCoordinateOnBoardSet0(x - 1, y);
        amountNeighbours += isCoordinateOnBoardSet0(x + 1, y);

        // Onderste 3 cellen
        amountNeighbours += isCoordinateOnBoardSet0(x - 1, y + 1);
        amountNeighbours += isCoordinateOnBoardSet0(x, y + 1);
        amountNeighbours += isCoordinateOnBoardSet0(x + 1, y + 1);
        return amountNeighbours;
    }

    public int isCoordinateOnBoardSet0(int x, int y) {

        if (x < 0 || x >= width) {
            return 0;
        }
        if (y < 0 || y >= height) {
            return 0;
        }
        return this.boardArray[x][y];
    }

    public int countAllLivingCells() {
        int cellCount = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (boardArray[x][y] == 1) {
                    cellCount++;
                }
            }
        }
        return cellCount;
    }


    public boolean allDeadCheck() {
        return (countAllLivingCells() == 0);
    }

    public void setDood(int x, int y) {
        this.boardArray[x][y] = 0;
    }

    public void setAlive(int x, int y) {
        this.boardArray[x][y] = 1;
    }

    public void setBoard(int[][] bord) {
        this.boardArray = bord;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getBoardArray() {
        return boardArray;
    }

    public int getBoardRows() {
        return boardArray.length;
    }

    public int getBoardColumns() {
        return boardArray[0].length;
    }
}



