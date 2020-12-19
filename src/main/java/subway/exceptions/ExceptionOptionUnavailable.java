package subway.exceptions;

import static subway.SubwayKeyWords.ERROR_OPTION_UNAVAILABLE;

public class ExceptionOptionUnavailable extends RuntimeException {

    public ExceptionOptionUnavailable() {
        super(ERROR_OPTION_UNAVAILABLE);
    }
}
