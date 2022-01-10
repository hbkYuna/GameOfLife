package be.kdg.gameoflife.view.game;

import be.kdg.gameoflife.view.ImageType;
import javafx.scene.image.ImageView;

public class CellView extends ImageView {

    private boolean isActive;

    public CellView() {
        super(ImageType.DEAD_CELL.getImage());
    }

    public void toggle() {
        if (isActive) {
            this.isActive = false;
            this.setImage(ImageType.DEAD_CELL.getImage());
        } else {
            this.isActive = true;
            this.setImage(ImageType.ALIVE_CELL.getImage());

        }
    }

    public void makeAlive(){
        this.isActive = true;
        this.setImage(ImageType.ALIVE_CELL.getImage());
    }

    public void makeDead(){
        this.isActive = false;
        this.setImage(ImageType.DEAD_CELL.getImage());
    }

    public boolean isActive() {
        return isActive;
    }
}
