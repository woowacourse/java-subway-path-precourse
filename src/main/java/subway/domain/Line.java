package subway.domain;

import java.util.ArrayList;
import java.util.List;


public class Line {
    private String name;
    private static final List<Station> stations = new ArrayList<>();

    private static final List<Integer> distance = new ArrayList<>();
    private static final List<Integer> time = new ArrayList<>();
    public Line() {
    }
    public Line(String name) {
        this.name = name;
    }
    // 추가 기능 구현

    public String getName() {
        return name;
    }

    public void setStations(List<String> tmpSaveStation) {
        for(int i=0;i<tmpSaveStation.size();i++){
            stations.add(new Station(tmpSaveStation.get(i)));
        }
    }
    public void setTime(List<Integer> tmpSaveTime) {
        System.out.println(name);
        for(int i=0;i<tmpSaveTime.size();i++) {
            this.time.add(tmpSaveTime.get(i));
        }
    }
    public void setDistance(List<Integer> tmpSaveDistance) {

        for(int i=0;i< tmpSaveDistance.size();i++) {

            System.out.println(tmpSaveDistance.get(i));
            distance.add(tmpSaveDistance.get(i));
        }
        System.out.println(distance.size());

    }
    public List<Station> getLineStation() {
        return stations;
    }
    public List<Integer> getLineDistance() {
        return distance;
    }
    public List<Integer> getLineTime() {
        return time;
    }

    public int getDistance(Station startStation,Station endStation) {

        int startIndex=stations.indexOf(startStation);
        int endIndex=stations.indexOf(endStation);


        if(startIndex>endIndex) {
           return computeDistance(endIndex,startIndex);
        }
        return computeDistance(startIndex,endIndex);
    }
    public int computeDistance(int startIndex,int endIndex) {
        int totalDistance=0;
        for(int i=startIndex;i<endIndex-1;i++) {

            totalDistance+=this.distance.get(i);
        }

        return totalDistance;
    }
    public int getTime(Station startStation,Station endStation) {

        int startIndex=stations.indexOf(startStation);
        int endIndex=stations.indexOf(endStation);
        if(startIndex>endIndex) {
            return computeTime(endIndex,startIndex);
        }

        return computeTime(startIndex,endIndex);
    }
    public int computeTime(int startIndex,int endIndex) {
        int totaltime=0;
        for(int i=startIndex;i<endIndex-1;i++) {


            totaltime+=time.get(i);
        }

        System.out.println(totaltime);
        return totaltime;
    }

}
