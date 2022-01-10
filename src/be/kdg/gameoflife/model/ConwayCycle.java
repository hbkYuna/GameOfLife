package be.kdg.gameoflife.model;

import java.util.HashMap;

public class ConwayCycle implements Cycle {


    HashMap<Integer, int[][]> map = new HashMap<Integer, int[][]>();
    int generationCount = 0;

    @Override
    public GameOfLife nextGeneration(GameOfLife gameOfLife) {
        int[][] newBoard = new int[gameOfLife.getWidth()][gameOfLife.getHeight()];
        int[][] model = gameOfLife.getBoardArray();

        for (int i = 0; i < gameOfLife.getHeight(); i++) {
            for (int j = 0; j < gameOfLife.getWidth(); j++) {
                int liveNeighbors = gameOfLife.countNeighbours(i, j);
                if (model[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    newBoard[i][j] = 1;
                } else if (model[i][j] == 0 && liveNeighbors == 3) {
                    newBoard[i][j] = 1;
                } else {
                    newBoard[i][j] = 0;
                }
            }
        }
        generationCount++;
        for (int i = 0; i < generationCount; i++) {
            map.put(generationCount, newBoard);
        }
        gameOfLife.setBoard(newBoard);
        return gameOfLife;
    }

    @Override
    public HashMap getBoardMap() {
        return map;
    }

    @Override
    public int getGenerationCount() {
        return generationCount;
    }

    @Override
    public void setGenerationCount(int generationCount) {
        this.generationCount = generationCount;
    }
}
