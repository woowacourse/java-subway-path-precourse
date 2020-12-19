package subway.controller;

import subway.view.OutputView;
import subway.view.resource.Screen;

public class MainController {
    private MainController(){
    }

    public static void run(){
        OutputView.loadView(Screen.MAIN);
    }
}
