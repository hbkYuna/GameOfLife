package be.kdg.gameoflife.model;


import java.util.HashMap;

public class CustomCycle implements Cycle {

    HashMap<Integer, int[][]> map = new HashMap<Integer, int[][]>();
    int generationCount = 0;

    public GameOfLife nextGeneration(GameOfLife gameOfLife) {
        int[][] nieuwbordx = new int[gameOfLife.getWidth()][gameOfLife.getHeight()];
        for (int y = 0; y < gameOfLife.getHeight(); y++) {
            for (int x = 0; x < gameOfLife.getWidth(); x++) {
                int burenLevend = gameOfLife.countNeighbours(x, y);
                if (gameOfLife.getBoardArray()[x][y] == 1) {
                    if (burenLevend < 2) {
                        nieuwbordx[x][y] = 0;
                    } else if (burenLevend > 1 && burenLevend < 6) {
                        nieuwbordx[x][y] = 1;
                    } else {
                        nieuwbordx[x][y] = 0;
                    }
                }
            }

        }

        generationCount++;
        for (int i = 0; i < generationCount; i++) {
            map.put(generationCount, nieuwbordx);
        }
        return gameOfLife;
    }

    @Override
    public HashMap getBoardMap() {
        return map;
    }

    @Override
        public int getGenerationCount () {
            return generationCount;
        }

    @Override
        public void setGenerationCount ( int generationCount){
            this.generationCount = generationCount;
        }
    }

