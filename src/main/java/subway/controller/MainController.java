package subway.controller;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.MainConsole;
import subway.view.MainMenu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static final String KYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YUKSAM = "역삼역";
    private static final String NAMBU = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAEFOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SHIN = "신분당선";

    private List<String> stations = Arrays.asList(KYODAE, GANGNAM, YUKSAM, NAMBU,
                                                    YANGJAE, YANGJAEFOREST, MAEBONG);
    private java.util.List<String> lines = Arrays.asList(LINE_TWO, LINE_THREE, LINE_SHIN);
    private MainConsole mainConsole;
    private final Scanner scanner;

    public MainController(Scanner scanner) {
        this.scanner = scanner;
        this.mainConsole = new MainConsole();
        onStart();
    }

    public void run() {
        while (true) {
            mainConsole.showMenu();
            MainMenu selector = mainConsole.selectMenu();
            if (selector == MainMenu.QUIT) {
                break;
            }
            selector.moveNext(selector.getKey());
        }
    }

    private void onStart() {
        stations.forEach(station -> StationRepository.addStation(new Station(station)));
        addLineTwo();
        addLineThree();
        addLineShin();
    }

    private void addLineTwo() {
        Line lineTwo = new Line(lines.get(0));
        lineTwo.addStations(stations.get(0), stations.get(1), stations.get(2));
        LineRepository.addLine(lineTwo);
    }

    private void addLineThree() {
        Line lineThree = new Line(lines.get(1));
        lineThree.addStations(stations.get(0), stations.get(3), stations.get(4), stations.get(6));
        LineRepository.addLine(lineThree);
    }

    private void addLineShin() {
        Line lineShin = new Line(lines.get(2));
        lineShin.addStations(stations.get(1), stations.get(4), stations.get(5));
        LineRepository.addLine(lineShin);
    }
}
