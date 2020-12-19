package subway;

import subway.view.MainView;
import subway.view.RouteLookupView;

import java.util.Scanner;

public class SubwayPath {
    public MainView mainView;
    public RouteLookupView routeLookupView;

    public SubwayPath(Scanner scanner) {
        mainView = new MainView(scanner);
        routeLookupView = new RouteLookupView(scanner);
    }

    public void run() {
//        mainView.render();
        routeLookupView.render();
    }
}
