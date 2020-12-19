package subway.utils;

import subway.view.ErrorMessage;

public class MenuControllerValidator {

    private static final int MINIMUM_DECISION_VALUE = 1;

    public static void validateDecision(String decision, int maxDecisionValue) {
        validateNumeric(decision);
    }

    private static void validateNumeric(String decision) {
        try {
            Integer.parseInt(decision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DECISION_WRONG);
        }
    }
}
