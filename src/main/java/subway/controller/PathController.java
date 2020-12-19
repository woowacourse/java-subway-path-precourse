package subway.controller;

import subway.graph.DistanceWeightedGraph;
import subway.graph.TimeWeightedGraph;
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

    private void nextProcedure(final String button) {
        if (button.equals(PathButton.BACK.getSymbol())) {
            return;
        }
        String source = inputView.getSourceStation();
        String destination = inputView.getDestinationStation();
        if (Validator.sameStation(source, destination)) {
            nextProcedure(button);
            return;
        }
        if (Validator.unconnected(source, destination)) {
            nextProcedure(button);
            return;
        }
        // 총 시간과 거리를 계산하는 함수를 구현하지 못했습니다.
        if (button.equals(PathButton.SHORTEST_PATH.getSymbol())) {
            OutputView.printInquiryGraph(DistanceWeightedGraph.getOptimalGraph(source, destination), -1, -1);
        } else if (button.equals(PathButton.LEAST_TIME.getSymbol())) {
            OutputView.printInquiryGraph(TimeWeightedGraph.getOptimalGraph(source, destination), -1, -1);
        }
    }

}
