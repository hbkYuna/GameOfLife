package be.kdg.gameoflife.view.about;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class AboutView extends BorderPane {

    private TextArea aboutText = new TextArea();

    public AboutView() {
        setCenter(aboutText);
        aboutText.setPrefWidth(Double.MAX_VALUE);
        aboutText.setPrefHeight(Double.MAX_VALUE);
        aboutText.setWrapText(true);
        aboutText.setFont(Font.font("Andale Mono",14));
        aboutText.setEditable(false);
        setPrefWidth(800);
        setPrefHeight(700);
    }

    TextArea getAboutText() {
        return aboutText;
    }


}
