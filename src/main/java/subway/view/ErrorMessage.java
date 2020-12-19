package subway.view;

import subway.domain.Constants;

public class ErrorMessage {
    public static void displayErrorMessage(int errorCase) {
        if (errorCase == Constants.FUNCTION_INPUT_ERROR)
            System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        if (errorCase == Constants.NO_SUCH_NAME_ERROR)
            System.out.println("[ERROR] 등록되지 않은 역 이름입니다.");
        if (errorCase == Constants.SAME_NAME_ERROR)
            System.out.println("[ERROR] 출발역과 도착역은 같을 수 없습니다.");
        if (errorCase == Constants.UNKNOWN_ERROR)
            System.out.println("[ERROR] 알 수 없는 오류가 발생했습니다.");
    }
}
