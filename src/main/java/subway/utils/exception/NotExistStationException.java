package subway.utils.exception;

import subway.view.output.ErrorOutputView;

public class NotExistStationException extends RuntimeException {
    public NotExistStationException() {
        ErrorOutputView.notExistStation();
    }
}
