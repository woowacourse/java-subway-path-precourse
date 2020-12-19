package subway.domain.station.dto;

public class StationSaveReqDto {
    private final String stationName;

    public StationSaveReqDto(String stationName) {
        this.stationName = stationName;
    }

    public String getStationName() {
        return stationName;
    }
}
