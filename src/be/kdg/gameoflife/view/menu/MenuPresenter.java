package be.kdg.gameoflife.view.menu;

import be.kdg.gameoflife.Main;
import be.kdg.gameoflife.model.GameOfLife;
import be.kdg.gameoflife.view.about.AboutPresenter;
import be.kdg.gameoflife.view.about.AboutView;
import be.kdg.gameoflife.view.game.GamePresenter;
import be.kdg.gameoflife.view.game.GameView;
import be.kdg.gameoflife.view.rules.RulesPresenter;
import be.kdg.gameoflife.view.rules.RulesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuPresenter {

    final MenuView view;
    GameOfLife gameOfLife = new GameOfLife(20, 20);
    GameView gameView = new GameView(gameOfLife);
    Main main = new Main();


    public MenuPresenter(MenuView view) {
        this.view = view;
        this.addEventHandlers();
    }

    public void addEventHandlers() {

        view.getBtnPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                GamePresenter gamePresenter = new GamePresenter(gameOfLife, gameView);
                view.getScene().setRoot(gameView);
                // gameView.getScene().getWindow().sizeToScene();
            }
        });

        view.getBtnRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage rules = new Stage();
                RulesView view = new RulesView();
                new RulesPresenter(view);
                Scene scene = new Scene(view);
                rules.setScene(scene);
                rules.setTitle("Game Of Life Rules");
                rules.show();

            }


        });
        view.getBtnAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage about = new Stage();
                AboutView view = new AboutView();
                new AboutPresenter(view);
                Scene scene = new Scene(view);
                about.setScene(scene);
                about.setTitle("Game Of life About");
                about.show();
            }
        });
    }
}