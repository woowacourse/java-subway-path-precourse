package subway.domain;

public class Distance {

    private static final int MINIMUM_KILOMETER = 1;
    private final int kilometer;

    private Distance(int kilometer) {
        validatePositive(kilometer);
        this.kilometer = kilometer;
    }

    private void validatePositive(int kilometer) {
        if(kilometer < MINIMUM_KILOMETER) {
            throw new IllegalArgumentException("역간 거리는 1 이상의 정수여야 합니다.");
        }
    }

    public static Distance newDistance(int kilometer) {
        return new Distance(kilometer);
    }

    public int getKilometer() {
        return kilometer;
    }
}
