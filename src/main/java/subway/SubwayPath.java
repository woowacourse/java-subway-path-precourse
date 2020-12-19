package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class SubwayPath {
    private InputView inputView;

    public SubwayPath(InputView inputView) {
        this.inputView = inputView;
    }

    public boolean run() {
        try {
            OutputView.showMainOption();
            String option = askOptionChoice();

            if (option.equals(MainOption.PATH.getValue())) {
                // TODO 경로조회
            }
            if (option.equals(MainOption.EXIT.getValue())) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private String askOptionChoice() {
        OutputView.askMainOptionChoice();
        List<MainOption> optionList = Arrays.asList(MainOption.values());
        return inputView.selectOption(optionList);
    }
}
