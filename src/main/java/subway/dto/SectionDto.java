package subway.dto;

import subway.domain.entity.Section;

public class SectionDto {

    private final int time;
    private final int distance;

    public SectionDto(int time, int distance) {
        this.time = time;
        this.distance = distance;
    }

    public Section toEntity() {
        return new Section(time, distance);
    }

    public int getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }
}
