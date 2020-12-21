package subway.screen;

import subway.PathResult;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

import static subway.domain.SectionRepository.*;

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
        PathResult pathResult = findshortestPath(input, departure, destination);
        OutputView.printRouteResult(pathResult);



        return GO_MAIN;
    }

    @Override
    public ScreenModel getNextScreen(String input) {
        return new MainScreen(scanner);
    }
}
