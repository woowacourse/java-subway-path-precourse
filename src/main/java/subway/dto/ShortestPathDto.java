package subway.dto;

import java.util.List;

public class ShortestPathDto {
    private final int km;
    private final int minute;
    private final List<String> stations;

    public ShortestPathDto(int km, int minute, List<String> stations) {
        this.km = km;
        this.minute = minute;
        this.stations = stations;
    }

    public int getKm() {
        return km;
    }

    public int getMinute() {
        return minute;
    }

    public List<String> getStations() {
        return stations;
    }
}
