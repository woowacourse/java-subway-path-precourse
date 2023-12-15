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
        String functionCode = askFunction();

        String pathStandardCode = askStandard();

        String startStation = askStartStation();

        String endStation = askEndStation();

        service.recommend(pathStandardCode);
    }

    private String askFunction() {
        View.printMenu();
        return scanner.next();
    }

    private String askStandard() {
        View.printPathStandard();
        return scanner.next();
    }

    private String askStartStation() {
        View.printStartStationMessage();
        return scanner.next();
    }

    private String askEndStation() {
        View.printEndStationMessage();
        return scanner.next();
    }

}
