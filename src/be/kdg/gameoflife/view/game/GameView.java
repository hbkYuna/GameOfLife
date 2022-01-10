package be.kdg.gameoflife.view.game;

import be.kdg.gameoflife.model.GameOfLife;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameView extends BorderPane {

    private final static Color GAMECOLOR = Color.SEAGREEN;
    private final static Color MENUCOLOR = Color.WHITE;
    private final static Color BTNCOLOR = Color.GRAY;

    public CellView[][] cells;
    private GridPane gridPane;

    public Slider gridChange;

    private Button btnStart;
    private Button btnSetting;
    private Button btnPause;
    private Button btnReset;
    private Button btnReturn;

    private Label genCount;
    private Label cellCount;

    private HBox topMenu;
    private VBox leftInfo;
    private VBox rightInfo;



    public GameView(GameOfLife gameOfLife) {
        this.initalizeNodes();
        this.layoutNodes();

        this.initialiseGridPane(gameOfLife);
        this.layoutGridPane();
    }


    public void initalizeNodes() {
        btnStart = new Button("Start");
        btnPause = new Button("Pause");
        btnSetting = new Button("<--");
        btnReset = new Button("Reset");
        btnReturn = new Button("Previous");

        genCount = new Label("Generations: 0");
        cellCount = new Label("Alive cells: 0");

        topMenu = new HBox();
        leftInfo = new VBox();
        rightInfo = new VBox();


    }

    private void initialiseGridPane(GameOfLife gameOfLife) {
        this.gridPane = new GridPane();

        this.cells = new CellView
                [gameOfLife.getWidth()]
                [gameOfLife.getHeight()];

        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                this.cells[i][j] = new CellView();
            }
        }
    }


    private void layoutGridPane() {
        //this.gridPane.setGridLinesVisible(true);
        this.gridPane.setPadding(new Insets(5.0));
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                this.gridPane.add(this.cells[i][j], i, j);
                GridPane.setMargin(this.cells[i][j], new Insets(1.0));
            }
        }

        setCenter(this.gridPane);
        gridPane.setAlignment(Pos.CENTER);
    }

    public void layoutNodes() {

        topMenu.getChildren().addAll(btnStart, btnPause, btnReset,btnSetting);
        setTop(topMenu);
        topMenu.setBackground(new Background(new BackgroundFill(MENUCOLOR, new CornerRadii(0), new Insets(0))));
        topMenu.setSpacing(78);

        int btnCountTop = topMenu.getChildren().size();
        btnReset.prefWidthProperty().bind(widthProperty().divide(btnCountTop));
        btnStart.prefWidthProperty().bind(widthProperty().divide(btnCountTop));
        btnPause.prefWidthProperty().bind(widthProperty().divide(btnCountTop));
        btnSetting.prefWidth(1);
        setBackground(new Background(new BackgroundFill(GAMECOLOR, new CornerRadii(0), new Insets(0))));

        setLeft(leftInfo);
        leftInfo.setSpacing(8);
        leftInfo.alignmentProperty().set(Pos.TOP_LEFT);
        leftInfo.getChildren().addAll(genCount, btnReturn);
        genCount.setFont(new Font(25));
        btnReturn.setFont(new Font(15));
        leftInfo.setMargin(btnReturn, new Insets(15));


        setRight(rightInfo);
        rightInfo.setSpacing(50);
        rightInfo.alignmentProperty().set(Pos.TOP_RIGHT);
        rightInfo.getChildren().add(cellCount);
        cellCount.setFont(new Font(25));


    }

    public CellView[][] getCells() {
        return cells;
    }

    public Button getBtnStart() {
        return btnStart;
    }

    public Button getBtnSetting() {
        return btnSetting;
    }

    public Button getBtnPause() {
        return btnPause;
    }

    public Button getBtnReset() {
        return btnReset;
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

    public Label getGenCount() {
        return genCount;
    }

    public Label getCellCount() {
        return cellCount;
    }
}

