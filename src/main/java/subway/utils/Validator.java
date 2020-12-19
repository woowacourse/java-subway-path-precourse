package subway.utils;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.repositories.DijkstraGraphRepository;
import subway.domain.repositories.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static boolean isValidMainInput(String inputMsg) {
        List<String> validMsgList = new ArrayList<>(Arrays.asList("1", "Q"));
        return validMsgList.contains(inputMsg);
    }

    public static boolean isValidPathInput(String inputMsg) {
        List<String> validMsgList = new ArrayList<>(Arrays.asList("1", "2", "B"));
        return validMsgList.contains(inputMsg);
    }

    public static boolean isValidStation(String name) {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            String stationName = station.getName();
            if (stationName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void sameStationNameCheck(String name1, String name2) {
        if (name1.equals(name2)) {
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다.");
        }
    }
}
