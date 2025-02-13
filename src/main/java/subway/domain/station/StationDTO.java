package subway.domain.station;

import java.util.Objects;

public class StationDTO {
    private static final String STATION_NAME_ESSENTIAL_MESSAGE = "역 이름은 필수입니다.";

    private final String name;

    public StationDTO(String name) {
        this.validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(STATION_NAME_ESSENTIAL_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(!(object instanceof StationDTO)) return false;
        StationDTO other = (StationDTO)object;
        return Objects.equals(this.name, other.name);
    }
}
