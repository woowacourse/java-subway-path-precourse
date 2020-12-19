package subway;

import java.util.Scanner;
import controller.MainController;
import subway.domain.Edge;
import subway.domain.Station;
import subway.domain.StationRepository;
import view.InputView;

public class Application {
    public static final String[] stationNames =
            {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    public static final String[] lineNames = {"2호선", "3호선", "신분당선"};
    public static final String[][] sections =
            {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView.scanner = scanner;
        init();
        MainController mainController = new MainController();
        mainController.run();
    }

    private static void init() {
        for (String name : stationNames) {
            StationRepository.addStation(new Station(name));
        }
        StationRepository.getStationByName("교대역")
                .addEdge(new Edge(StationRepository.getStationByName("강남역"), 2, 3));
        StationRepository.getStationByName("교대역")
                .addEdge(new Edge(StationRepository.getStationByName("남부터미널역"), 3, 2));

        StationRepository.getStationByName("강남역")
                .addEdge(new Edge(StationRepository.getStationByName("교대역"), 2, 3));
        StationRepository.getStationByName("강남역")
                .addEdge(new Edge(StationRepository.getStationByName("역삼역"), 2, 3));
        StationRepository.getStationByName("강남역")
                .addEdge(new Edge(StationRepository.getStationByName("양재역"), 10, 3));

        StationRepository.getStationByName("역삼역")
                .addEdge(new Edge(StationRepository.getStationByName("강남역"), 2, 3));

        StationRepository.getStationByName("남부터미널역")
                .addEdge(new Edge(StationRepository.getStationByName("교대역"), 3, 2));
        StationRepository.getStationByName("남부터미널역")
                .addEdge(new Edge(StationRepository.getStationByName("양재역"), 1, 1));

        StationRepository.getStationByName("양재역")
                .addEdge(new Edge(StationRepository.getStationByName("양재시민의숲역"), 10, 3));
        StationRepository.getStationByName("양재역")
                .addEdge(new Edge(StationRepository.getStationByName("매봉역"), 1, 1));
        StationRepository.getStationByName("양재역")
                .addEdge(new Edge(StationRepository.getStationByName("강남역"), 2, 8));

        StationRepository.getStationByName("양재시민의숲역")
                .addEdge(new Edge(StationRepository.getStationByName("양재역"), 10, 3));

        StationRepository.getStationByName("매봉역")
                .addEdge(new Edge(StationRepository.getStationByName("양재역"), 1, 1));
    }
}
