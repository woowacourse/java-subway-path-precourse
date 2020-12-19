package subway.domain.validator;

import subway.domain.exception.InvalidDistanceException;

public class DistanceValidator {
    private DistanceValidator() {
    }

    public static void checkIsPositive(int value) {
        if (value <= 0) {
            throw new InvalidDistanceException("거리는 양의 정수만 가능합니다.");
        }
    }
}
