package subway.exception;

import subway.util.ErrorViewUtil;

public class StateNotInitializedException extends IllegalArgumentException {
    private static final String errorMessage = "뷰 상태가 제대로 초기화 되지 않았습니다.";

    public StateNotInitializedException() {
        super(ErrorViewUtil.getErrorPrefix() + " " + errorMessage);
    }
}
