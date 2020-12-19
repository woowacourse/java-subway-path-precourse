package subway.exception;

import subway.util.ErrorViewUtil;

public class DuplicatedStartAndEndException extends IllegalArgumentException {
    private static final String errorMessage = "기점과 종점이 동일합니다.";

    public DuplicatedStartAndEndException() {
        super(ErrorViewUtil.getErrorPrefix() + " " + errorMessage);
    }
}
