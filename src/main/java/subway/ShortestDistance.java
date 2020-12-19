package subway;

import subway.domain.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestDistance {

    private ArrayList<ApplicationInitializer.Edge>[] subwayNetwork;
    private Map<Station, Integer> stationMapper = new HashMap<>();

    public ShortestDistance(Map<Station, Integer> stationMapper,
                                ArrayList<ApplicationInitializer.Edge>[] subwayNetwork) {
        this.subwayNetwork = subwayNetwork;
        this.stationMapper = stationMapper;
    }

    public void calculateShortestDistance() {
        try {
            Station station = new Station()
            Station station = new Station(new StationName(inputView.inputStationToRegister()));
            if (stationRepository.containsStation(station)) {
                throw new IllegalArgumentException("[ERROR] 지하철 역 이름이 중복됩니다.");
            }
            stationRepository.addStation(station);
            OutputView.printStationEnrolled();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            register();
        }
    }
}
