package subway.utils.exception;

import subway.view.output.ErrorOutputView;

public class InvalidSequnceLineException extends RuntimeException {
    public InvalidSequnceLineException() {
        ErrorOutputView.invalidSequenceLine();
    }
}
