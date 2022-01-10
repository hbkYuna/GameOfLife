package be.kdg.gameoflife.view.about;

import be.kdg.gameoflife.model.About;

public class AboutPresenter {

    public AboutPresenter(AboutView aboutView){
        aboutView.getAboutText().setText(new About().getAbout());
    }
}


