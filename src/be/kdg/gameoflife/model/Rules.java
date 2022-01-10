package be.kdg.gameoflife.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Rules {

    private String rules = "";

    public Rules() {
        InputStream inputStream = getClass().getResourceAsStream("/rules.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rules += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getGOLRules() {
        return rules;
    }
}


