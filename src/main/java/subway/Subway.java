package subway;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Route;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.screen.MainScreen;
import subway.screen.RouteCriterionScreen;
import subway.view.Input;
import subway.view.Output;

public class Subway {
    private static final String INQURY_ROUTE = "1";
    private static final String SHORTEST_DISTANCE_ROUTE = "1";
    
    public static boolean progress = true;
	
    public Subway(Scanner scanner) {
        initialization();
        Input.scanner = scanner;
    }
    
    public void run() {
        while (progress) {
            Output.printMenu(new MainScreen());
            if (Input.chooseFunction().equals(INQURY_ROUTE)) {
                executeRouteCriterionMenu();
            }
        }
    }
    
    public void executeRouteCriterionMenu() {
        Output.printMenu(new RouteCriterionScreen());
        if (Input.chooseFunction().equals(SHORTEST_DISTANCE_ROUTE)) {
            Station departureStation = StationRepository.getStationByName(Input.inputDepartureStation());
            Station arrivalStation = StationRepository.getStationByName(Input.inputArrivalStation());
            List<Station> shortestDistancePath = Route.getShortestDistanceRoute(departureStation, arrivalStation);
            for (Station station : shortestDistancePath) {
                Output.printResult(station.getName());
            }
        }
    }
   
    public void initialization() {
        initializeStation();
        initializeLine();
        initializeSection();
    }
    
    public void initializeStation() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String stationName : stations) {
            StationRepository.addStation(new Station(stationName));
        }
    }
    
    public void initializeLine() {
        List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");
        for (String lineName : lines) {
            LineRepository.addLine(new Line(lineName));
        }
    }
    
    public void initializeSection() {
        LineRepository.addSection(LineRepository.getLineByName("2호선"), new Section(StationRepository.getStationByName("교대역"),StationRepository.getStationByName("강남역"),2,3));
        LineRepository.addSection(LineRepository.getLineByName("2호선"), new Section(StationRepository.getStationByName("강남역"),StationRepository.getStationByName("역삼역"),2,3));
        LineRepository.addSection(LineRepository.getLineByName("3호선"), new Section(StationRepository.getStationByName("교대역"),StationRepository.getStationByName("남부터미널역"),3,2));
        LineRepository.addSection(LineRepository.getLineByName("3호선"), new Section(StationRepository.getStationByName("남부터미널역"),StationRepository.getStationByName("양재역"),6,5));
        LineRepository.addSection(LineRepository.getLineByName("3호선"), new Section(StationRepository.getStationByName("양재역"),StationRepository.getStationByName("매봉역"),3,2));
        LineRepository.addSection(LineRepository.getLineByName("신분당선"), new Section(StationRepository.getStationByName("강남역"),StationRepository.getStationByName("양재역"),2,8));
        LineRepository.addSection(LineRepository.getLineByName("신분당선"), new Section(StationRepository.getStationByName("양재역"),StationRepository.getStationByName("양재시민의숲역"),10,3));
    }
}
