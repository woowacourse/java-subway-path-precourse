package subway.controller;

import java.util.Scanner;

import subway.domain.StationGraph;
import subway.menu.MainMenu;
import subway.view.InputView;

public class SubwayPathController {
    private InputView inputView;
    private MainMenu mainMenu;
    private SubwayPathControllerInitializer subwayPathControllerInitializer;
    private StationGraph stationGraph;

    public SubwayPathController(Scanner scanner) {
        inputView = new InputView(scanner);
        mainMenu = new MainMenu(inputView);
        stationGraph = new StationGraph();
        subwayPathControllerInitializer = new SubwayPathControllerInitializer(stationGraph);
        init();
    }

    private void init() {
        subwayPathControllerInitializer.initDefaultStationName();
        subwayPathControllerInitializer.initDefaultStationLine();
        subwayPathControllerInitializer.makeInitDefaultStationSection();
    }

    public void run() {
        while (true) {
            mainMenu.runMenu();
        }
    }
}
