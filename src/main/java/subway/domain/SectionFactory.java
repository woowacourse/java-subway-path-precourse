package subway.domain;

import subway.exception.SubwayException;

public class SectionFactory {

    public static final String ERROR_NOT_POSITIVE_MSG = "거리 혹은 시간은 양의 정수여야 합니다.";

    public static Section makeSection(Station from, Station to, int distance, int takenTime) {
        isPositiveDigit(distance);
        isPositiveDigit(takenTime);
        return new Section(from, to, distance, takenTime);
    }

    private static void isPositiveDigit(int number) {
        if (number <= 0) {
            throw new SubwayException(ERROR_NOT_POSITIVE_MSG);
        }
    }

}
