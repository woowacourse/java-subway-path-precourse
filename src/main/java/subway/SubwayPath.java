package subway;

import subway.view.MainView;

import java.util.Scanner;

public class SubwayPath {
    public MainView mainView;

    public SubwayPath(Scanner scanner){
        mainView = new MainView(scanner);
    }

    public void run() {
        mainView.render();
    }
}
