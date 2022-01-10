package be.kdg.gameoflife;

import be.kdg.gameoflife.view.menu.MenuPresenter;
import be.kdg.gameoflife.view.menu.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {




    @Override
    public void start(Stage stage) throws Exception {

        MenuView menuView = new MenuView();
        MenuPresenter menuPresenter = new MenuPresenter(menuView);
        stage.setScene(new Scene(menuView));
        stage.setTitle("Game of life");
        stage.setResizable(true);
        stage.setMinHeight(300);
        stage.setMinWidth(300);
        stage.setHeight(700);
        stage.setWidth(1100);
        stage.show();


        menuView.setStyle(
                "-fx-background-image: url(" +
                        "'images/artistic-retro-wave-grid-mountain-wallpaper-preview.jpg'" +
                        "); " +
                        "-fx-background-size: stretch;");
    }

    public static void main(String[] args) { Application.launch(args); }


}

