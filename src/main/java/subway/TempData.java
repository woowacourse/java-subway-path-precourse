package subway;

import subway.domain.*;
import subway.util.Dijkstra;

import java.util.Arrays;
import java.util.List;

public class TempData {
    private static final List<Station> stations=Arrays.asList(new Station("교대역"),new Station("강남역"),new Station("역삼역"),
            new Station("남부터미널역"),new Station("양재역"),new Station("양재시민의숲역"),new Station("매봉역"));
    public static void load(){
        StationRepository.saveAll(stations);
        LineRepository.saveAll(Arrays.asList(new Line("2호선"),new Line("3호선"),new Line("신분당선")));
        edgeInit();
        vertexInit();
        distanceInit();
        timeInit();
    }

    public static void edgeInit(){
        StationEdgeRepository.addStation(new StationEdge(stations.get(0).getName(),stations.get(1).getName(),2,3));
        StationEdgeRepository.addStation(new StationEdge(stations.get(1).getName(),stations.get(2).getName(),2,3));

        StationEdgeRepository.addStation(new StationEdge(stations.get(0).getName(),stations.get(3).getName(),3,2));
        StationEdgeRepository.addStation(new StationEdge(stations.get(3).getName(),stations.get(4).getName(),6,5));
        StationEdgeRepository.addStation(new StationEdge(stations.get(4).getName(),stations.get(6).getName(),1,1));

        StationEdgeRepository.addStation(new StationEdge(stations.get(1).getName(),stations.get(4).getName(),2,8));
        StationEdgeRepository.addStation(new StationEdge(stations.get(4).getName(),stations.get(5).getName(),10,3));
    }

    public static void vertexInit(){
        stations.forEach(station -> Dijkstra.getInstance().addVertex(station.getName()));
    }

    public static void distanceInit(){
        Dijkstra.getInstance().setEdgeDistanceWeight(stations.get(0).getName(),stations.get(1).getName(),2);
        Dijkstra.getInstance().setEdgeDistanceWeight(stations.get(1).getName(),stations.get(2).getName(),2);

        Dijkstra.getInstance().setEdgeDistanceWeight(stations.get(0).getName(),stations.get(3).getName(),3);
        Dijkstra.getInstance().setEdgeDistanceWeight(stations.get(3).getName(),stations.get(4).getName(),6);
        Dijkstra.getInstance().setEdgeDistanceWeight(stations.get(4).getName(),stations.get(6).getName(),1);

        Dijkstra.getInstance().setEdgeDistanceWeight(stations.get(1).getName(),stations.get(4).getName(),2);
        Dijkstra.getInstance().setEdgeDistanceWeight(stations.get(4).getName(),stations.get(5).getName(),10);
    }

    public static void timeInit(){
        Dijkstra.getInstance().setEdgeTimeWeight(stations.get(0).getName(),stations.get(1).getName(),3);
        Dijkstra.getInstance().setEdgeTimeWeight(stations.get(1).getName(),stations.get(2).getName(),3);

        Dijkstra.getInstance().setEdgeTimeWeight(stations.get(0).getName(),stations.get(3).getName(),2);
        Dijkstra.getInstance().setEdgeTimeWeight(stations.get(3).getName(),stations.get(4).getName(),5);
        Dijkstra.getInstance().setEdgeTimeWeight(stations.get(4).getName(),stations.get(6).getName(),1);

        Dijkstra.getInstance().setEdgeTimeWeight(stations.get(1).getName(),stations.get(4).getName(),8);
        Dijkstra.getInstance().setEdgeTimeWeight(stations.get(4).getName(),stations.get(5).getName(),3);
    }
}
