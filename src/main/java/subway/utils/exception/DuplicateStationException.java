package subway.utils.exception;

import subway.view.output.ErrorOutputView;

public class DuplicateStationException extends RuntimeException {
    public DuplicateStationException() {
        ErrorOutputView.duplicateStation();
    }
}
