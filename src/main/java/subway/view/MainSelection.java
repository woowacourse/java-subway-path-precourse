package subway.view;

import subway.exception.ErrorCode;
import subway.exception.SelectionException;

public class MainSelection {
    private final static String OPTION_ONE = "1";
    private final static String OPTION_QUIT = "Q";

    private final String option;

    public MainSelection(String option) {
        this.option = option;
        validate(option);
    }

    private void validate(String option) {
        if (!option.equals(OPTION_ONE) && !option.equals(OPTION_QUIT)) {
            throw new SelectionException(ErrorCode.INVALID_INPUT_VALUE);
        }
    }

    public String getOption() {
        return option;
    }
}
