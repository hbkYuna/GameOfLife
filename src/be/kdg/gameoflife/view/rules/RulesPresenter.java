package be.kdg.gameoflife.view.rules;

import be.kdg.gameoflife.model.Rules;

public class RulesPresenter {

    public RulesPresenter(RulesView rulesView){
        rulesView.getTaRules().setText(new Rules().getGOLRules());
    }
}
