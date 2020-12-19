package subway.domain;

import java.util.Scanner;

public class Input {

    InputValidator validator = new InputValidator();

    public String mainChoice(Scanner scanner) {
        String mainInput = scanner.next();
        validator.checkMain(mainInput);
        return mainInput;
    }

    public String findPath(Scanner scanner) {
        String pathInput = scanner.next();
        validator.checkPath(pathInput);
        return pathInput;
    }

    public String findStation(Scanner scanner) {
        String station = scanner.next();
        validator.checkStation(station);
        return station;
    }
}
