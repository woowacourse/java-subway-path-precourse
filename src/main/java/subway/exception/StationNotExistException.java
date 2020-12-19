package subway.exception;

import subway.util.ErrorViewUtil;

public class StationNotExistException extends IllegalArgumentException {
    private static final String errorMessage = "존재하지 않는 역 이름입니다.";

    public StationNotExistException() {
        super(ErrorViewUtil.getErrorPrefix() + " " + errorMessage);
    }
}
