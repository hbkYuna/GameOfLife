package be.kdg.gameoflife.model;

import java.util.HashMap;

public interface Cycle {




    GameOfLife nextGeneration(GameOfLife gameOfLife);

    public int getGenerationCount();

    public void setGenerationCount(int generationCount);

    public HashMap getBoardMap();

}
