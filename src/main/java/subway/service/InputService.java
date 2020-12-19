package subway.service;

import subway.view.InputView;

import java.util.Scanner;

public class InputService extends InputView {

    public String inputSelectMenu(Scanner scanner) {
        inputSelectMenuMessage();
        String menu = scanner.nextLine();
        return menu;
    }

    public String inputStartStationName(Scanner scanner) {
        inputStartStationNameMessage();
        String stationName = scanner.nextLine();
        return stationName;
    }

    public String inputEndStationName(Scanner scanner) {
        inputEndStationNameMessage();
        String stationName = scanner.nextLine();
        return stationName;
    }
}