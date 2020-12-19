package subway.controller;

import java.util.Scanner;

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
        if (mainInputValidation.input().equals(MainInputEnum.TRAVERSE_SUBWAY.getOption())) {
            traverse();
        }
        if (mainInputValidation.input().equals(MainInputEnum.QUIT.getOption())) {
            return;
        }
    }

    private void traverse() {
        OutputView.printTraverseScreen();
        TraverseInputValidation traverseInputValidation = new TraverseInputValidation(inputView);
        OutputView.printTraverseScreen();
        if (traverseInputValidation.input()
            .equals(TraverseInputEnum.SHORTEST_DISTANCE.getOption())) {
            return;
        }
        if (traverseInputValidation.input().equals(TraverseInputEnum.SHORTEST_TIME.getOption())) {
            return;
        }
        if (traverseInputValidation.input().equals(TraverseInputEnum.BACK.getOption())) {
            run();
        }
    }

    private void init() {

    }
}
