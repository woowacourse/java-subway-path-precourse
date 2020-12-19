package subway.screen;

import subway.domain.SectionRepository;
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
        int shortestResult = 0;

        String departure = inputView.enterDeparture();
        String arrival = inputView.enterArrival();
        shortestResult = SectionRepository.findShortestPath(departure, arrival);
        System.out.println(shortestResult);

        return "-1";
    }

}
