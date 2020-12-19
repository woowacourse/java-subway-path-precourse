package subway;

import java.util.Arrays;
import java.util.List;
import subway.domain.graph.DistanceGraphRepository;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.graph.TimeGraphRepository;

public class DummySetup {

    private static final List<String> dummyStationNames = Arrays.asList(
            "교대역",
            "강남역",
            "역삼역",
            "남부터미널역",
            "양재역",
            "양재시민의숲역",
            "매봉역"
    );

    private static final List<String> dummyLineNames = Arrays.asList(
            "2호선",
            "3호선",
            "신분당선"
    );

    public static void initialize() {
        initializeStations();
        initializeLines();
        connectStationsAndLines();
    }

    public static void initializeStations() {
        dummyStationNames.stream()
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    private static void initializeLines() {
        dummyLineNames.stream()
                .map(Line::new)
                .forEach(LineRepository::addLine);
    }

    private static void connectStationsAndLines() {
        connectSecondLine();
        connectThirdLine();
        connectNewBundangLine();
    }

    private static void connectSecondLine() {
        Line secondLine = LineRepository.get("2호선");
        secondLine.addStation(StationRepository.get("교대역"));
        secondLine.addStation(StationRepository.get("강남역"));
        secondLine.addStation(StationRepository.get("역삼역"));

        addDistanceAndTimeSecondLine();
    }

    private static void connectThirdLine() {
        Line thirdLine = LineRepository.get("3호선");
        thirdLine.addStation(StationRepository.get("교대역"));
        thirdLine.addStation(StationRepository.get("남부터미널역"));
        thirdLine.addStation(StationRepository.get("양재역"));
        thirdLine.addStation(StationRepository.get("매봉역"));

        addDistanceAndTimeThirdLine();
    }

    private static void connectNewBundangLine() {
        Line newBundangLine = LineRepository.get("신분당선");
        newBundangLine.addStation(StationRepository.get("강남역"));
        newBundangLine.addStation(StationRepository.get("양재역"));
        newBundangLine.addStation(StationRepository.get("양재시민의숲역"));

        addDistanceAndTimeNewBundangLine();
    }

    private static void addDistanceAndTimeSecondLine() {
        DistanceGraphRepository.addStationsWithDistance("교대역", "강남역", 2);
        TimeGraphRepository.addStationsWithTime("교대역", "강남역", 3);

        DistanceGraphRepository.addStationsWithDistance("강남역", "역삼역", 2);
        TimeGraphRepository.addStationsWithTime("강남역", "역삼역", 3);
    }

    private static void addDistanceAndTimeThirdLine() {
        DistanceGraphRepository.addStationsWithDistance("교대역", "남부터미널역", 3);
        TimeGraphRepository.addStationsWithTime("교대역", "남부터미널역", 2);

        DistanceGraphRepository.addStationsWithDistance("남부터미널역", "양재역", 6);
        TimeGraphRepository.addStationsWithTime("남부터미널역", "양재역", 5);

        DistanceGraphRepository.addStationsWithDistance("양재역", "매봉역", 1);
        TimeGraphRepository.addStationsWithTime("양재역", "매봉역", 1);
    }

    private static void addDistanceAndTimeNewBundangLine() {
        DistanceGraphRepository.addStationsWithDistance("강남역", "양재역", 2);
        TimeGraphRepository.addStationsWithTime("강남역", "양재역", 8);

        DistanceGraphRepository.addStationsWithDistance("양재역", "양재시민의숲역", 10);
        TimeGraphRepository.addStationsWithTime("양재역", "양재시민의숲역", 3);
    }
}
