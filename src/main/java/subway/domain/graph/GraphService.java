package subway.domain.graph;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import static subway.domain.util.SetupConstant.*;

public class GraphService {
    public void setUp() {
        setUpDistanceGraph();
        setUpTimeGraph();
    }

    private void setUpDistanceGraph() {
        updateDistanceGraph(LINE_2, STATION_GYODAE, STATION_GANGNAM, DIST_GYODAE_TO_GANGNAM);
        updateDistanceGraph(LINE_2, STATION_GANGNAM, STATION_YEOKSAM, DIST_GANGNAM_TO_YEOKSAM);
        updateDistanceGraph(LINE_3, STATION_GYODAE, STATION_NAMBU_TERMINAL, DIST_GYODAE_TO_NAMBU_TERMINAL);
        updateDistanceGraph(LINE_3, STATION_NAMBU_TERMINAL, STATION_YANGJAE, DIST_NAMBU_TERMINAL_TO_YANGJAE);
        updateDistanceGraph(LINE_3, STATION_YANGJAE, STATION_MAEBONG, DIST_YANGJAE_TO_MAEBONG);
        updateDistanceGraph(LINE_SINBUNDANG, STATION_GANGNAM, STATION_YANGJAE, DIST_GANGNAM_TO_YANGJAE);
        updateDistanceGraph(LINE_SINBUNDANG, STATION_YANGJAE, STATION_YANGJAE_CITIZENS_FOREST, DIST_YANGJAE_TO_YANGJAE_CITIZEN_FOREST);
    }

    private void setUpTimeGraph() {
        updateTimeGraph(LINE_2, STATION_GYODAE, STATION_GANGNAM, TIME_GYODAE_TO_GANGNAM);
        updateTimeGraph(LINE_2, STATION_GANGNAM, STATION_YEOKSAM, TIME_GANGNAM_TO_YEOKSAM);
        updateTimeGraph(LINE_3, STATION_GYODAE, STATION_NAMBU_TERMINAL, TIME_GYODAE_TO_NAMBU_TERMINAL);
        updateTimeGraph(LINE_3, STATION_NAMBU_TERMINAL, STATION_YANGJAE, TIME_NAMBU_TERMINAL_TO_YANGJAE);
        updateTimeGraph(LINE_3, STATION_YANGJAE, STATION_MAEBONG, TIME_YANGJAE_TO_MAEBONG);
        updateTimeGraph(LINE_SINBUNDANG, STATION_GANGNAM, STATION_YANGJAE, TIME_GANGNAM_TO_YANGJAE);
        updateTimeGraph(LINE_SINBUNDANG, STATION_YANGJAE, STATION_YANGJAE_CITIZENS_FOREST, TIME_YANGJAE_TO_YANGJAE_CITIZEN_FOREST);
    }

    private void updateDistanceGraph(String lineName, String stationName1, String stationName2, int pathWeight) {
        Line line = LineRepository.findByName(lineName);
        DistanceGraph graph = findPresentDistancegraph(line);
        if (graph == null)
            graph = new DistanceGraph(line);
        Station station1 = StationRepository.findByName(stationName1);
        Station station2 = StationRepository.findByName(stationName2);
        DistanceGraph updatedGraph = createDistanceGraph(graph, station1, station2, pathWeight);
        DistanceGraphRepository.addGraph(updatedGraph);
    }

    private void updateTimeGraph(String lineName, String stationName1, String stationName2, int pathWeight) {
        Line line = LineRepository.findByName(lineName);
        TimeGraph graph = findPresentTimegraph(line);
        if (graph == null)
            graph = new TimeGraph(line);
        Station station1 = StationRepository.findByName(stationName1);
        Station station2 = StationRepository.findByName(stationName2);
        TimeGraph updatedGraph = createTimeGraph(graph, station1, station2, pathWeight);
        TimeGraphRepository.addGraph(updatedGraph);
    }

    private DistanceGraph createDistanceGraph(DistanceGraph distanceGraph, Station station1, Station station2, int pathWeight) {
        distanceGraph.updateGraph(station1, station2, pathWeight);
        return distanceGraph;
    }

    private TimeGraph createTimeGraph(TimeGraph timeGraph, Station station1, Station station2, int pathWeight) {
        timeGraph.updateGraph(station1, station2, pathWeight);
        return timeGraph;
    }

    private DistanceGraph findPresentDistancegraph(Line line) {
        return DistanceGraphRepository.findByLine(line);
    }

    private TimeGraph findPresentTimegraph(Line line) {
        return TimeGraphRepository.findByLine(line);
    }

}
