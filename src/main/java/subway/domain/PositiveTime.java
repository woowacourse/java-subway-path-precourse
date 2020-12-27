package subway.domain;

public class PositiveTime {
    private static final int POSITIVE_TIME_LIMIT = 1;

    private int time;

    public PositiveTime(int time) {
        if (time < POSITIVE_TIME_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 시간은 양수입니다.");
        }
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
