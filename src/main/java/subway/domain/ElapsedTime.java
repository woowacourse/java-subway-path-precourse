package subway.domain;

public class ElapsedTime {

    public static final int MINIMUM_TIME = 1;

    public static final String NOT_POSITIVE_ERROR = "소요 시간은 양의 정수이어야 합니다.";

    private final int time;

    public ElapsedTime(int time) {
        if (time < MINIMUM_TIME) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR);
        }

        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
