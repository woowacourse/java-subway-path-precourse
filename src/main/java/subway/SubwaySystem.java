package subway;

import subway.domain.MainMenu;
import subway.domain.Station;
import subway.domain.repositories.DijkstraGraphRepository;
import subway.domain.repositories.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubwaySystem {
    private void subWayInit() {
        stationInit();
        DijkstraGraphRepository.graphInit();
    }

    private void stationInit() {
        List<String> stationsNames = new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        for (String stationName : stationsNames) {
            StationRepository.addStation(new Station(stationName));
            DijkstraGraphRepository.addVertexByStationName(stationName);
        }
    }

    public void run(Scanner scanner) {
        subWayInit();
        while (MainMenu.isMainRunning()) {
            MainMenu.mainRun(scanner);
        }
    }
}
