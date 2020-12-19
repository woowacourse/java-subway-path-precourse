package subway.domain.entity;

public class Section {
    private static final int MINIMUM_POSITIVE_INTEGER = 1;

    private final int time;
    private final int distance;

    public Section(int time, int distance) {
        validateSection(time, distance);
        this.time = time;
        this.distance = distance;
    }

    private void validateSection(int time, int distance) {
        if (time < MINIMUM_POSITIVE_INTEGER || distance < MINIMUM_POSITIVE_INTEGER) {
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
