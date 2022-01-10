package be.kdg.gameoflife.view;

import javafx.scene.image.Image;

public enum ImageType {
    DEAD_CELL("images/deadCell.png"),
    ALIVE_CELL("images/aliveCell.png");

    private final Image image;

    ImageType(String path) {
        this.image = new Image(path);
    }


    public Image getImage() {
        return image;
    }
}
