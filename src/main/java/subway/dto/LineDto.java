package subway.dto;

public class LineDto {

    private final String lineName;
    private final String upwardLastStationName;
    private final String nextStationName;

    public LineDto(String lineName, String upwardLastStationName, String nextStationName) {
        this.lineName = lineName;
        this.upwardLastStationName = upwardLastStationName;
        this.nextStationName = nextStationName;
    }

    public String getLineName() {
        return lineName;
    }

    public String getUpwardLastStationName() {
        return upwardLastStationName;
    }

    public String getNextStationName() {
        return nextStationName;
    }
}
