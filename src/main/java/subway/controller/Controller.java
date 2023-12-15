package subway.controller;

import subway.domain.StationRepository;
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
        validateDifferentStation(startStation, endStation);

        service.recommend(pathStandardCode, startStation, endStation);
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

        String startStation = scanner.next();
        validationStation(startStation);

        return startStation;
    }

    private String askEndStation() {
        View.printEndStationMessage();

        String endStation = scanner.next();
        validationStation(endStation);

        return endStation;
    }

    private void validationStation(String stationName) {
        if (!StationRepository.existByName(stationName)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 지하철역입니다.");
        }
    }

    private void validateDifferentStation(String startStation, String endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException("[ERROR] 출발역과 도착역이 동일합니다.");
        }
    }

}
