package subway.utils.exception;

import subway.view.output.ErrorOutputView;

public class InvalidStationNameException extends RuntimeException {
    public InvalidStationNameException() {
        ErrorOutputView.invalidStationName();
    }
}
