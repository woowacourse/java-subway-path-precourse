package subway.type;

public enum TimeType {
    EDUCATION_UNIVERSITY_TO_GANGNAM(3),
    GANGNAM_TO_YEOKSAM(3),

    EDUCATION_UNIVERSITY_TO_NAMBU_TERMINAL(2),
    NAMBU_TERMINAL_TO_YANGJAE(5),
    YANGJAE_TO_MAEBONG(1),

    GANGNAM_TO_YANGJAE(8),
    YANGJAE_TO_YANGJAE_FOREST(3);

    private final int time;

    TimeType(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
