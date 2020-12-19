package subway.controller;

import java.util.Scanner;
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
        StationRepository.isExistedStation(candidate);
        return candidate;
    }

    abstract public void showPath(String departure, String terminal);
}
