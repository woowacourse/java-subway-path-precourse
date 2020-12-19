package subway;

import subway.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Subway {

    private static final List<String> INIT_LINES = List.of("2호선:교대역-강남역-역삼역", "3호선:교대역-남부터미널역-양재역-매봉역", "신분당선:강남역-양재역-양재시민의숲역");
    private static final List<String> INIT_WEIGHTS =
            List.of("교대역:남부터미널역=2/3", "강남역:역삼역=2/3", "교대역:남부터미널역=3/2", "남부터미널역:양재역=6/5", "양재역:매봉역=1/1",
                    "강남역:양재역=2/8", "양재역:양재시민의숲역=10/3");

    private static final String TIME_GRAPH = "timeGraph";
    private static final String DISTANCE_GRAPH = "distanceGraph";


    public Subway() {

        for (String line : INIT_LINES) {
            String[] split = line.split(":");

            String[] stationNames = split[1].split("-");
            saveStations(stationNames);

            String lineName = split[0];
            saveLines(lineName);
        }

        saveStationWeight();

    }

    private void saveWeights() {

        GraphRepository.addGraph(TIME_GRAPH);
        GraphRepository.addGraph(DISTANCE_GRAPH);
    }

    private void saveStationWeight() {
        for (String connection : INIT_WEIGHTS) {

            String[] split = connection.split("=");
            List<Station> stations = getStations(split[0].split(":"));

            String[] weights = split[1].split("/");

            String distance = weights[0];
            String time = weights[1];

            makeConnection(stations, distance, time);
        }
    }

    private void makeConnection(List<Station> stations, String distance, String time) {
        try {

            GraphRepository.findGraphByName(TIME_GRAPH).makeConnection(stations.get(0), stations.get(1), Integer.parseInt(time));
            GraphRepository.findGraphByName(DISTANCE_GRAPH).makeConnection(stations.get(0), stations.get(1), Integer.parseInt(distance));

        } catch (NullPointerException e) {
            // error
        }
    }

    private List<Station> getStations(String[] stations) {
        List<Station> stationList = new ArrayList<>();
        for (String stationName : stations) {
            stationList.add(StationRepository.findStationByName(stationName));
        }

        return stationList;
    }

    private void saveLines(String lineName) {
        LineRepository.addLine(new Line(lineName));
    }

    private void saveStations(String[] stations) {
        for (String stationName : stations) {
            StationRepository.addStation(new Station(stationName));
        }
    }
}
