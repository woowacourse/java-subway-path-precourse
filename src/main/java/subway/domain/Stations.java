package subway.domain;

public class Stations {
    private String upStationName;
    private String downStationName;

    public Stations(String upStationName, String downStationName) {
        this.upStationName = upStationName;
        this.downStationName = downStationName;
    }

    public String getUpStationName() {
        return upStationName;
    }

    public String getDownStationName() {
        return downStationName;
    }
}
