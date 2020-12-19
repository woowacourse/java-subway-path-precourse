package subway;

import subway.controller.Initializer;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SubwayProgram {
    private final Scanner scanner;

    public SubwayProgram(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        Initializer.stationInitialize();
        StationRepository.printAllStations();
    }
}
