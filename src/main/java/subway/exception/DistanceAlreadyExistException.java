package subway.exception;

import subway.util.ErrorViewUtil;

public class DistanceAlreadyExistException extends IllegalArgumentException {
    private static final String errorMessage = "이미 추가된 거리입니다.";

    public DistanceAlreadyExistException() {
        super(ErrorViewUtil.getErrorPrefix() + " " + errorMessage);
    }
}
