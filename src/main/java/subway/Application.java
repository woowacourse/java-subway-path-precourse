package subway;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.mainview.MainView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView.scanner = scanner;
        initSetting();
        MainView mainView = new MainView();
        mainView.setVisible();
    }

    private static void initSetting() {
        initStations();
        initLines();
        initSection();
    }

    private static void initStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void initLines() {
        LineRepository.addLine(Line.of("2호선", Arrays.asList(
            StationRepository.findByName("교대역"),
            StationRepository.findByName("강남역"),
            StationRepository.findByName("역삼역")
        )));

        LineRepository.addLine(Line.of("3호선", Arrays.asList(
            StationRepository.findByName("교대역"),
            StationRepository.findByName("남부터미널역"),
            StationRepository.findByName("양재역"),
            StationRepository.findByName("매봉역")
        )));

        LineRepository.addLine(Line.of("신분당선", Arrays.asList(
            StationRepository.findByName("강남역"),
            StationRepository.findByName("양재역"),
            StationRepository.findByName("양재시민의숲역")
        )));
   }

    private static void initSection() {
        SectionRepository.addSection(StationRepository.findByName("교대역"), StationRepository.findByName("강남역"), 2, 3);
        SectionRepository.addSection(StationRepository.findByName("강남역"), StationRepository.findByName("역삼역"), 2, 3);

        SectionRepository.addSection(StationRepository.findByName("교대역"), StationRepository.findByName("남부터미널역"), 3, 2);
        SectionRepository.addSection(StationRepository.findByName("남부터미널역"), StationRepository.findByName("양재역"), 6, 5);
        SectionRepository.addSection(StationRepository.findByName("양재역"), StationRepository.findByName("매봉역"), 1, 1);

        SectionRepository.addSection(StationRepository.findByName("강남역"), StationRepository.findByName("양재역"), 2, 8);
        SectionRepository.addSection(StationRepository.findByName("양재역"), StationRepository.findByName("양재시민의숲역"), 10, 3);
    }
}
