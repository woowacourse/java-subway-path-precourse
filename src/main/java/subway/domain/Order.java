package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final StartStation startStation;
    private final EndStation endStation;
    private int spendTime;
    private int length;

    public Order(StartStation start, EndStation end){
        this.startStation = start;
        this.endStation = end;
    }

    public List<String> findLengthResult(){
        List<String> result = new ArrayList<>();
        for( Line line : LineRepository.lines()){
            result = checkArray(result, line.calculateLength(startStation.getStationName(), endStation.getStationName()));
        }
        return result;
    }

    public List<String> findTimeResult(){
        List<String> result = new ArrayList<>();
        for( Line line : LineRepository.lines()){
            result = checkArray(result, line.calculateTime(startStation.getStationName(), endStation.getStationName()));
        }
        return result;
    }

    private List<String> checkArray(List<String> first, List<String> second){
        if(!second.isEmpty()){
            return second;
        }
        return first;
    }
}
