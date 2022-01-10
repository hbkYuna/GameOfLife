package be.kdg.gameoflife.view.rules;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class RulesView extends BorderPane {


        private TextArea taRules = new TextArea();

    public RulesView() {
        setCenter(taRules);
        taRules.setPrefWidth(Double.MAX_VALUE);
        taRules.setPrefHeight(Double.MAX_VALUE);
        taRules.setWrapText(true);
        taRules.setFont(Font.font("Andale Mono",14));
        taRules.setEditable(false);
        setPrefWidth(800);
        setPrefHeight(700);
    }

        TextArea getTaRules() {
        return taRules;
    }


}



