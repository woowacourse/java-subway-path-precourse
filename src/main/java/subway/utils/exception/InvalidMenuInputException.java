package subway.utils.exception;

import subway.view.ErrorOutputView;

public class InvalidMenuInputException extends RuntimeException {
    public InvalidMenuInputException() {
        ErrorOutputView.invalidMenuInput();
    }
}
