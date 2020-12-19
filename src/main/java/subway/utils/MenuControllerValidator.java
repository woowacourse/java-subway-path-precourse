package subway.utils;

import subway.view.message.ErrorMessage;

public class MenuControllerValidator {

    private static final int MINIMUM_DECISION_VALUE = 1;

    public static void validateDecision(String decision, int maxDecisionValue) {
        validateNumeric(decision);
        validateRange(decision, maxDecisionValue);
    }

    private static void validateNumeric(String decision) {
        try {
            Integer.parseInt(decision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DECISION_WRONG);
        }
    }

    private static void validateRange(String decision, int maxDecisionValue) {
        if (outOfRange(Integer.parseInt(decision), maxDecisionValue)) {
            throw new IllegalArgumentException(ErrorMessage.DECISION_WRONG);
        }
    }

    private static boolean outOfRange(int decision, int maxDecisionValue) {
        return (decision > maxDecisionValue || decision < MINIMUM_DECISION_VALUE);
    }
}
