package subway.screen;

import subway.domain.SectionRepository;
import subway.Menu.Menu;
import subway.view.InputView;

import java.util.Scanner;

public class FeatureScreen implements ScreenModel {

    private final Scanner scanner;
    private final String input;

    public FeatureScreen(Scanner scanner, String input) {
        this.scanner = scanner;
        this.input = input;
    }

    @Override
    public String showScreen() {
        InputView inputView = new InputView(scanner);
        String departure = inputView.enterDeparture();
        String destination = inputView.enterDestination();

        if (input.equals(Menu.ROUTE_CRITERIA.SHORTEST_PATH.getCode())) {
            SectionRepository.findShortestPathByDistance(departure, destination);
        }

        if (input.equals(Menu.ROUTE_CRITERIA.SHORTEST_TIME.getCode())) {
            SectionRepository.findShortestPathByCostTime(departure, destination);
        }

        return GO_MAIN;
    }

    @Override
    public ScreenModel getNextScreen(String input) {
        return new MainScreen(scanner);
    }
}
