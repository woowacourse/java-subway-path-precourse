package subway.dto;

public class PathRequestDto {

    private final String firstStationName;
    private final String lastStationName;

    public PathRequestDto(String firstStationName, String lastStationName) {
        this.firstStationName = firstStationName;
        this.lastStationName = lastStationName;
    }

    public String getFirstStationName() {
        return firstStationName;
    }

    public String getLastStationName() {
        return lastStationName;
    }
}
