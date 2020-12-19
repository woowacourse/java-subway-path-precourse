package subway.utils.exception;

import subway.view.output.ErrorOutputView;

public class InvalidMenuInputException extends RuntimeException {
    public InvalidMenuInputException() {
        ErrorOutputView.invalidMenuInput();
    }
}
