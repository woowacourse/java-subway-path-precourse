package subway;

import subway.controller.LineController;
import subway.controller.StationController;

import java.util.Scanner;

public class Application {

    private static final LineController lineController = new LineController();
    private static final StationController stationController = new StationController();
    public static void main(String[] args) {
        lineController.initLine();
        stationController.initStation();
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
    }
}
