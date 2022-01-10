package be.kdg.gameoflife.view.game;

import be.kdg.gameoflife.model.ConwayCycle;
import be.kdg.gameoflife.model.Cycle;
import be.kdg.gameoflife.model.GameOfLife;
import be.kdg.gameoflife.view.menu.MenuView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class GamePresenter {

    private GameOfLife model;
    private final GameView gameView;
    private final Cycle ConwayCycle;
    private Timeline timeline;

    public GamePresenter(GameOfLife model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        addEventHandlers();
        this.ConwayCycle = new ConwayCycle();
        setupTimeLine();

    }

    private void setupTimeLine() {
        timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!model.allDeadCheck()) {
                            model = ConwayCycle.nextGeneration(model);
                            gameView.getGenCount().setText("Generations: " + ConwayCycle.getGenerationCount());
                            gameView.getCellCount().setText("Alive cells: " + model.countAllLivingCells());
                            colorCells();
                        } else {
                            timeline.stop();
                        }
                    }
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    private void addEventHandlers() {
        for (int i = 0; i < gameView.getCells().length; i++) {
            for (int j = 0; j < gameView.getCells()[i].length; j++) {
                gameView.getCells()[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (timeline.getStatus() == Animation.Status.STOPPED) {
                            CellView cellView = (CellView) mouseEvent.getSource();
                            cellView.toggle();
                        }
                    }
                });
            }
        }
        gameView.getBtnStart().setOnMouseClicked(mouseEvent -> {
            for (int i = 0; i < gameView.getCells().length; i++) {
                for (int j = 0; j < gameView.getCells()[i].length; j++) {
                    if (gameView.getCells()[i][j].isActive()) {
                        model.setAlive(i, j);
                    }
                }
            }

            timeline.play();
        });
        gameView.getBtnPause().setOnMouseClicked(mouseEvent -> {
            timeline.stop();
        });
        gameView.getBtnReset().setOnMouseClicked(mouseEvent -> {
            timeline.stop();
            for (int i = 0; i < model.getBoardArray().length; i++) {

                for (int j = 0; j < model.getBoardArray()[i].length; j++) {
                    this.model.setDood(i, j);
                    this.gameView.getCells()[i][j].makeDead();
                    ConwayCycle.setGenerationCount(0);
                    gameView.getCellCount().setText("Alive cells: 0");
                }
            }
        });

// Poging tot, er komen geen errors van dus laat ik het staan (geen tijd meer om af te maken)

        gameView.getBtnReturn().setOnMouseClicked(mouseEvent -> {

            timeline.stop();
            ConwayCycle.setGenerationCount(ConwayCycle.getGenerationCount() - 1);
            model.setBoard((int[][]) ConwayCycle.getBoardMap().get(ConwayCycle.getGenerationCount() - 1));
            gameView.getGenCount().setText("Generations: " + ConwayCycle.getGenerationCount());
        });

        gameView.getBtnSetting().setOnMouseClicked(mouseEvent -> {
            MenuView menuView = new MenuView();
            gameView.getScene().setRoot(menuView);
        });
    }

    private void colorCells() {
        for (int i = 0; i < model.getBoardArray().length; i++) {
            for (int j = 0; j < model.getBoardArray()[i].length; j++) {
                if (model.getBoardArray()[i][j] == 1) {
                    this.gameView.getCells()[i][j].makeAlive();
                } else {
                    this.gameView.getCells()[i][j].makeDead();
                }
            }
        }

    }
}

