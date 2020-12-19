package subway.domain;

public class Time {

    private static final int MINIMUM_MINUTE = 1;
    private final int minute;

    private Time(int minute) {
        validatePositive(minute);
        this.minute = minute;
    }

    public static Time newTime(int minute) {
        return new Time(minute);
    }

    private void validatePositive(int minute) {
        if (minute < MINIMUM_MINUTE) {
            throw new IllegalArgumentException("소요 시간은 1 이상의 정수여야 합니다.");
        }
    }

    public int getMinute() {
        return minute;
    }
}
