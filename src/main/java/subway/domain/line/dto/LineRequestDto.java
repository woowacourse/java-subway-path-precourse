package subway.domain.line.dto;

public class LineRequestDto {

    private final String name;
    private final String upstreamStationName;
    private final String downstreamStationName;
    private final double distance;
    private final double time;

    public LineRequestDto(String name, String upstreamStationName,
        String downstreamStationName, double distance, double time) {
        this.name = name;
        this.upstreamStationName = upstreamStationName;
        this.downstreamStationName = downstreamStationName;
        this.distance = distance;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getUpstreamStationName() {
        return upstreamStationName;
    }

    public String getDownstreamStationName() {
        return downstreamStationName;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}
