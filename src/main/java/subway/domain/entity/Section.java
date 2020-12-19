package subway.domain.entity;

public class Section {
    private static final int MINIMUM_POSITIVE_INTEGER = 1;

    private final int distance;
    private final int time;

    public Section(int distance, int time) {
        validateSection(distance, time);
        this.distance = distance;
        this.time = time;
    }

    private void validateSection(int distance, int time) {
        if (distance < MINIMUM_POSITIVE_INTEGER || time < MINIMUM_POSITIVE_INTEGER) {
            throw new InvalidSectionDataException();
        }
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
