package subway.controller;

import subway.service.InitializationService;

import java.util.Scanner;

public class SubwayController {
    public static void runSubway(Scanner scanner) {
        initializeSubway();
    }

    public static void initializeSubway() {
        InitializationService.initializeStations();
        InitializationService.initializeLines();
    }
}
