package subway.dto;

import subway.domain.entity.Section;

public class SectionDto {

    private final int distance;
    private final int time;

    public SectionDto(int distance, int time) {
        this.distance = distance;
        this.time = time;
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
