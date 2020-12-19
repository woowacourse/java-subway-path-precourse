package subway.util;

import subway.domain.*;
import subway.view.Input;

import java.util.List;
import java.util.Scanner;

public class GraphInitializer {
    public static final String ASK_SOURCE = "## 출발역을 입력하세요.";
    public static final String ASK_DESTINATION = "## 도착역을 입력하세요.";

    public GraphInitializer(String command, Scanner scanner) {
        GraphRepository graphRepository = new GraphRepository();
        for(Station station : StationRepository.stations()) {
            graphRepository.addVertex(station.getName());
        }

        if(command.equals("1")) {
            byDistance(graphRepository);
        }
        if(command.equals("2")) {
            byTime(graphRepository);
        }

        String [] stations = getStations(scanner);
        List<String> shortestPath = graphRepository.calPath(stations[0], stations[1]);
        printShortestPath(shortestPath);

    }

    public void byDistance(GraphRepository graphRepository) {
        for(Edge edge : EdgeRepository.edges()) {
            graphRepository.setWeight(edge.getStation1(), edge.getStation2(), edge.getDistance());
        }
    }

    public void byTime(GraphRepository graphRepository) {
        for(Edge edge : EdgeRepository.edges()) {
            graphRepository.setWeight(edge.getStation1(), edge.getStation2(), edge.getTime());
        }
    }

    public String [] getStations(Scanner scanner) {
        String [] stations = new String[2];
        stations[0] = Input.getSourceStation(scanner);
        stations[1] = Input.getDestinationStation(scanner);
        return stations;
    }

    public void printShortestPath(List<String> ShortestPath) {
        for(String path : ShortestPath) {
            System.out.println(path);
        }
    }

}
