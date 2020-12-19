package subway.controller;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.exception.constant.MainInputEnum;
import subway.exception.constant.TraverseInputEnum;
import subway.exception.validation.MainInputValidation;
import subway.exception.validation.TraverseInputValidation;
import subway.view.InputView;
import subway.view.OutputView;

public class Subway {

    private InputView inputView;

    public Subway(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        MainInputValidation mainInputValidation = new MainInputValidation(inputView);
        OutputView.printMainScreen();
        String mainInput = mainInputValidation.input();
        if (mainInput.equals(MainInputEnum.TRAVERSE_SUBWAY.getOption())) {
            traverse();
        }
    }

    private void traverse() {
        OutputView.printTraverseScreen();
        TraverseInputValidation traverseInputValidation = new TraverseInputValidation(inputView);
        String function = traverseInputValidation.input();
        if (
            function.equals(TraverseInputEnum.SHORTEST_DISTANCE.getOption())) {
            LineRepository.getDijkstraShortestPath();
            return;
        }
        if (function.equals(TraverseInputEnum.SHORTEST_TIME.getOption())) {
            System.out.println("d");
            return;
        }
        run();
    }
}
