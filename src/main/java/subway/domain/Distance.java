package subway.domain;

public class Distance {

    private final int kilometer;

    private Distance(int kilometer) {
        this.kilometer = kilometer;
    }

    public static Distance newDistance(int kilometer) {
        return new Distance(kilometer);
    }

    public int getKilometer() {
        return kilometer;
    }
}
