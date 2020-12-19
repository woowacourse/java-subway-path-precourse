package subway.view;

import subway.domain.Constants;

public class ErrorMessage {
    public static void displayErrorMessage(int errorCase) {
        if (errorCase == Constants.FUNCTION_INPUT_ERROR)
            System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
    }
}
