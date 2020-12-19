package subway;

import subway.Controller.SubwayController;
import subway.config.SubwayConfig;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        SubwayController subwayController = new SubwayController(scanner);
        SubwayConfig.subwayMapInit();

        subwayController.run();
    }
}
