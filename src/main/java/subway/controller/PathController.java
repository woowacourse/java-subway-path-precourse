package subway.controller;

import subway.util.Validator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PathController {

    private final InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    private final List<String> buttons = Arrays.asList(
            PathButton.SHORTEST_PATH.getSymbol(),
            PathButton.LEAST_TIME.getSymbol(),
            PathButton.BACK.getSymbol()
    );

    public void run() {
        OutputView.printInquiry();
        String selectedButton = inputView.getFunctionSelect(buttons);
        nextProcedure(selectedButton);
    }

    private void nextProcedure(String button) {
        if (button.equals(PathButton.BACK.getSymbol())) {
            return;
        }
        String source = inputView.getSourceStation();
        String destination = inputView.getDestinationStation();
        if (Validator.sameStation(source, destination)) {
            nextProcedure(button);
            return;
        }

        if (button.equals(PathButton.SHORTEST_PATH.getSymbol())) {
            System.out.println("최단거리로 계산");
            OutputView.printEmptyLine();
        } else if (button.equals(PathButton.LEAST_TIME.getSymbol())) {
            System.out.println("최소시간으로 계산");
            OutputView.printEmptyLine();
        }
    }



}
