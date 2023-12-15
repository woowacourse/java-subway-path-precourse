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

        String code = scanner.next();

        switch (code) {
            case "1":
                service.recommend();
                break;
        }
    }
}
