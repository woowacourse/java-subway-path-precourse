package subway.domain.validator;

import subway.domain.exception.InvalidDistanceException;

public class TimeValidator {
    private TimeValidator() {
    }

    public static void checkIsPositive(int value) {
        if (value <= 0) {
            throw new InvalidDistanceException("시간은 양의 정수만 가능합니다.");
        }
    }
}
