package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PathController {

    private final List<String> buttons = Arrays.asList(
            PathButton.SHORTEST_PATH.getSymbol(),
            PathButton.LEAST_TIME.getSymbol(),
            PathButton.BACK.getSymbol()
    );

    public void run(InputView inputView) {
        OutputView.printInquiry();
        String selectedButton = inputView.getFunctionSelect(buttons);
        nextProcedure(selectedButton);
    }

    private void nextProcedure(String button) {
        System.out.println("선택한 버튼 " + button + " <- 이거 맞지??");
        System.out.println("경로 선택 해보자구 짜라랑 ~");
    }

}
