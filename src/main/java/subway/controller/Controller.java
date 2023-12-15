package subway.controller;

import subway.service.SubwayPathRecommendationService;
import subway.view.View;

import java.util.Scanner;

public class Controller {
    private final Scanner scanner;
    private final SubwayPathRecommendationService service;

    public Controller(Scanner scanner, SubwayPathRecommendationService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void run() {
        View.printMenu();
        String functionCode = scanner.next();

        View.printPathStandard();
        String pathStandardCode = scanner.next();


        View.printStartStationMessage();
        String startStation = scanner.next();

        View.printEndStationMessage();
        String endStation = scanner.next();

        service.recommend(pathStandardCode);
    }
}
