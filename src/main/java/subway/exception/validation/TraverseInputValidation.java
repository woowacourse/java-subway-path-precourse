package subway.exception.validation;

import java.util.Arrays;

import subway.exception.SubwayCustomException;
import subway.exception.constant.TraverseInputEnum;
import subway.view.InputView;
import subway.view.OutputView;

public class TraverseInputValidation {


    private static final String TRAVERSE_FUNCTION_ERROR = "1, 2, B 중에 하나를 입력해주세요.";

    private final InputView inputView;

    public TraverseInputValidation(InputView inputView) {
        this.inputView = inputView;
    }

    public String input() {
        String function = this.inputView.inputFunction();
        try {
            if (Arrays.stream(TraverseInputEnum.values())
                .anyMatch(traverseInputEnum -> traverseInputEnum.getOption().equals(function))) {
                return function;
            }
            throw new SubwayCustomException(TRAVERSE_FUNCTION_ERROR);
        } catch (SubwayCustomException e) {
            OutputView.printError(e);
            return input();
        }
    }
}
