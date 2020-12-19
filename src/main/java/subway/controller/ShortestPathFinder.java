package subway.controller;

import subway.Exception.CustomException;
import subway.view.InputView;

import java.util.Scanner;

public class ShortestPathFinder {
    private final Scanner scanner;

    public ShortestPathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String startStation = askValidStation();
        System.out.println("입력하신 역은 " + startStation);
    }

    private String askValidStation() {
        try {
            return InputView.askStartStation(scanner);
        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
            return askValidStation();
        }
    }
}
