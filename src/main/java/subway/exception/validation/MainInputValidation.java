package subway.exception.validation;

import java.util.Arrays;

import subway.exception.SubwayCustomException;
import subway.exception.constant.MainInputEnum;
import subway.view.InputView;
import subway.view.OutputView;

public class MainInputValidation {

    private final InputView inputView;

    private static final String MAIN_FUNCTION_ERROR = "1, Q 중에 하나를 입력해주세요.";

    public MainInputValidation(InputView inputView) {
        this.inputView = inputView;
    }

    public String mainInput() {
        String function = this.inputView.inputFunction();
        try {
            if (Arrays.stream(MainInputEnum.values())
                .noneMatch(mainInputEnum -> mainInputEnum.getOption().equals(function))) {
                throw new SubwayCustomException(MAIN_FUNCTION_ERROR);
            }
            return function;
        } catch (SubwayCustomException e) {
            OutputView.printError(e);
            return mainInput();
        }
    }
}
