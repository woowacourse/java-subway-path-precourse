package subway;

import subway.domain.*;
import subway.screen.MainScreen;
import subway.screen.ScreenManager;
import subway.screen.ScreenModel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initialize();
        ScreenManager.addNextMenuScreen(new MainScreen(scanner));

        while (!ScreenManager.isEmpty()) {
            ScreenModel nextScreen = ScreenManager.pop();
            ScreenManager.show(nextScreen);
        }
    }

    private static void initialize() {
        List<Station> stations = Arrays.asList(new Station("교대역"), new Station("강남역")
                , new Station("역삼역"), new Station("남부터미널역"), new Station("양재역")
                , new Station("양재시민의숲역"), new Station("매봉역"));
        stations.stream().forEach(station -> StationRepository.addStation(station));

        List<Line> lines = Arrays.asList(new Line("2호선").addTerminus("교대역", "역삼역")
                , new Line("3호선").addTerminus("교대역", "매봉역")
                , new Line("신분당선").addTerminus("강남역", "양재시민의숲역"));
        lines.stream().forEach(line -> LineRepository.addLine(line));

        List<Section> sections = Arrays.asList(new Section("2호선", "교대역", "강남역", 2, 3)
                , new Section("2호선", "강남역", "역삼역", 2, 3)
                , new Section("3호선", "교대역", "남부터미널역", 3, 2)
                , new Section("3호선", "남부터미널역", "양재역", 6, 5)
                , new Section("3호선", "양재역", "매봉역", 1, 1));
        sections.stream().forEach(section -> SectionRepository.addSection(section));

    }
}
