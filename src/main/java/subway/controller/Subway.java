package subway.controller;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.exception.constant.MainInputEnum;
import subway.exception.constant.TraverseInputEnum;
import subway.exception.validation.MainInputValidation;
import subway.exception.validation.StationInputValidation;
import subway.exception.validation.TraverseInputValidation;
import subway.view.InputView;
import subway.view.OutputView;

public class Subway {

    private MainInputValidation mainInput;
    private TraverseInputValidation traverseInput;
    private StationInputValidation stationInput;

    public Subway(Scanner scanner) {
        InputView inputView = new InputView(scanner);
        this.mainInput = new MainInputValidation(inputView);
        this.traverseInput = new TraverseInputValidation(inputView);
        this.stationInput = new StationInputValidation(inputView);
    }


    public void run() {
        OutputView.printMainScreen();
        String function = mainInput.input();
        if (function.equals(MainInputEnum.TRAVERSE_SUBWAY.getOption())) {
            traverse();
        }
    }

    private void traverse() {
        OutputView.printTraverseScreen();
        String function = traverseInput.input();
        if (
            function.equals(TraverseInputEnum.SHORTEST_DISTANCE.getOption())) {
            String startStation = stationInput.input()[0];
            String endStation = stationInput.input()[1];
            LineRepository.getDijkstraShortestDistancePath(startStation, endStation);
        }
        if (function.equals(TraverseInputEnum.SHORTEST_TIME.getOption())) {
            System.out.println("d");
            return;
        }
        run();
    }
}
