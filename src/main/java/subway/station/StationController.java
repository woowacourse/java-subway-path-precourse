package subway.station;

import java.util.ArrayList;
import java.util.List;

public class StationController {

    private StationService stationService;

    public StationController() {
        this.stationService = new StationService();
    }

    public void stationInitialize() {
        List<Station> stationNameList = new ArrayList<>();

        for (BasicStation station : BasicStation.values()) {
            stationNameList.add(new Station(station.getName()));
        }

        stationService.addAllStation(stationNameList);
    }
}
