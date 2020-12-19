package subway.domain.line.dto;

public class SectionInsertRequestDto {

    private final String lineName;
    private final String stationName;
    private final double distance;
    private final double time;

    public SectionInsertRequestDto(String lineName, String stationName, double distance,
        double time) {
        this.lineName = lineName;
        this.stationName = stationName;
        this.distance = distance;
        this.time = time;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}
