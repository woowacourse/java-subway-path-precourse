package subway.common;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SelectOption {
    public static String askOptionChoice(InputView inputView, List<String> optionList) {
        OutputView.askOptionChoice();
        return inputView.selectOption(optionList);
    }
}
