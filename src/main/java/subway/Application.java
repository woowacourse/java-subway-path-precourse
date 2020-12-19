package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.MainMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        initializeRepositories();
        MainMenu.initialize(scanner);
    }

    private static void initializeRepositories() {
        initializeStationRepository();
        initializeLineRepository();
    }

    private static void initializeLineRepository() {
        Line line2 = new Line("2호선");
        initializeLine2EdgesAndWeights(line2);
        LineRepository.addLine(line2);
        Line line3 = new Line("3호선");
        initializeLine3EdgesAndWeights(line3);
        LineRepository.addLine(line3);
        Line sinbundangLine = new Line("신분당선");
        initializeSinbundangLineEdgesAndWeights(sinbundangLine);
        LineRepository.addLine(sinbundangLine);
    }

    private static void initializeSinbundangLineEdgesAndWeights(Line sinbundangLine) {
        List<String[]> edgesAndWeights = new ArrayList<>();
        edgesAndWeights.add(new String[]{"강남역", "양재역", "2km", "8분"});
        edgesAndWeights.add(new String[]{"양재역", "양재시민의숲역", "10km", "3분"});
        sinbundangLine.addEdgesAndWeights(edgesAndWeights);
    }

    private static void initializeLine3EdgesAndWeights(Line line3) {
        List<String[]> edgesAndWeights = new ArrayList<>();
        edgesAndWeights.add(new String[]{"교대역", "남부터미널역", "3km", "2분"});
        edgesAndWeights.add(new String[]{"남부터미널역", "양재역", "6km", "5분"});
        edgesAndWeights.add(new String[]{"양재역", "매봉역", "1km", "1분"});
        line3.addEdgesAndWeights(edgesAndWeights);
    }

    private static void initializeLine2EdgesAndWeights(Line line2) {
        List<String[]> edgesAndWeights = new ArrayList<>();
        edgesAndWeights.add(new String[]{"교대역", "강남역", "2km", "3분"});
        edgesAndWeights.add(new String[]{"강남역", "역삼역", "2km", "3분"});
        line2.addEdgesAndWeights(edgesAndWeights);
    }

    private static void initializeStationRepository() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        stationNames.forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }
}
