package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final StartStation startStation;
    private final EndStation endStation;

    public Order(StartStation start, EndStation end) {
        this.startStation = start;
        this.endStation = end;
    }

    public List<String> findLengthResult() {
        List<String> result = new ArrayList<>();
        for (Line line : LineRepository.lines()) {
            result = checkArray(result, line.calculateLength(startStation.getStationName(), endStation.getStationName()));
        }
        return result;
    }

    public List<String> findTimeResult() {
        List<String> result = new ArrayList<>();
        for (Line line : LineRepository.lines()) {
            result = checkArray(result, line.calculateTime(startStation.getStationName(), endStation.getStationName()));
        }
        return result;
    }

    private List<String> checkArray(List<String> first, List<String> second) {
        if (!second.isEmpty()) {
            return second;
        }
        return first;
    }

    public int calculateLength() {
        int shortest = 100;
        for (Line line : LineRepository.lines()) {
            shortest = Math.min(shortest, line.getLength(startStation.getStationName(), endStation.getStationName()));
        }
        return shortest;
    }

    public int calculateTime() {
        int shortest = 100;
        for (Line line : LineRepository.lines()) {
            shortest = Math.min(shortest, line.getTime(startStation.getStationName(), endStation.getStationName()));
        }
        return shortest;
    }
}
