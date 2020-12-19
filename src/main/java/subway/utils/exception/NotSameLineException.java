package subway.utils.exception;

import subway.view.output.ErrorOutputView;

public class NotSameLineException extends RuntimeException {
    public NotSameLineException() {
        ErrorOutputView.notSameLine();
    }
}