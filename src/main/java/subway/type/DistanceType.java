package subway.type;

public enum DistanceType {
    EDUCATION_UNIVERSITY_TO_GANGNAM(2),
    GANGNAM_TO_YEOKSAM(2),

    EDUCATION_UNIVERSITY_TO_NAMBU_TERMINAL(3),
    NAMBU_TERMINAL_TO_YANGJAE(6),
    YANGJAE_TO_MAEBONG(1),

    GANGNAM_TO_YANGJAE(2),
    YANGJAE_TO_YANGJAE_FOREST(10);

    private final int distance;

    DistanceType(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
