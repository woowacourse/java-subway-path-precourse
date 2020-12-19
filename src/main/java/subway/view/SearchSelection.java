package subway.view;

import subway.exception.ErrorCode;
import subway.exception.SelectionException;

public class SearchSelection {
    private final static String OPTION_ONE = "1";
    private final static String OPTION_TWO = "2";
    private final static String OPTION_BACK = "B";
    private final static String OPTION_BACK_LOWERCASE = "b";

    private final String option;

    public SearchSelection(String option) {
        this.option = option;
        validate(option);
    }

    private void validate(String option) {
        if (!option.equals(OPTION_ONE) && !option.equals(OPTION_TWO)
                && !option.equals(OPTION_BACK) && !option.equals(OPTION_BACK_LOWERCASE)) {
            throw new SelectionException(ErrorCode.INVALID_INPUT_VALUE);
        }
    }

    public String getOption() {
        return option;
    }
}
