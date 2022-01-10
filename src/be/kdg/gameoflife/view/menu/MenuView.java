package be.kdg.gameoflife.view.menu;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;


public class MenuView extends VBox {
    private Button btnPlay;
    private Button btnRules;
    private Button btnAbout;


    public MenuView() {
        this.initalizenodes();
        this.layoutNodes();
    }

    public void initalizenodes() {
        this.btnPlay = new Button("Play");
        this.btnRules = new Button("Rules");
        this.btnAbout = new Button("About");
    }

    public void layoutNodes() {
        this.setSpacing(8);
        getChildren().add(btnPlay);
        getChildren().add(btnRules);
        getChildren().add(btnAbout);
        this.setAlignment(Pos.CENTER);

        int btnCount = getChildren().size();
        btnPlay.prefWidthProperty().bind(widthProperty().divide(btnCount));
        btnRules.prefWidthProperty().bind(widthProperty().divide(btnCount));
        btnAbout.prefWidthProperty().bind(widthProperty().divide(btnCount));

    }


    public Button getBtnPlay() {
        return btnPlay;
    }

    public Button getBtnRules() {
        return btnRules;
    }

    public Button getBtnAbout() {
        return btnAbout;
    }
}


