package subway.controller;

import java.util.Scanner;
import subway.controller.constants.ControllerError;
import subway.domain.StationRepository;
import subway.view.PathInputView;

abstract public class ShortestPathFinder {

    private final Scanner scanner;

    ShortestPathFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void findPath() {
        PathInputView.askDeparture();
        String depature = validTerminal();
        PathInputView.askTerminal();
        String terminal = validTerminal();
        showPath(depature, terminal);
    }

    public String validTerminal() {
        String candidate = scanner.nextLine();

        if (!StationRepository.isExistedStation(candidate)) {
            System.out.println(ControllerError.NO_EXISTED_STATION);
            throw new IllegalArgumentException(ControllerError.NO_EXISTED_STATION);
        }

        return candidate;
    }

    abstract public void showPath(String departure, String terminal);
}
