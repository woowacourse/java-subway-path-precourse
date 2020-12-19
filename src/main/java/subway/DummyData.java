package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DummyData {
    private static final String[] initialStation = new String[]{"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String[] initialLine = new String[]{"2호선", "3호선", "신분당선"};

    private DummyData() {
    }

    public static void initialize() {
        initializeLinesAndStations();
    }

    private static void initializeLinesAndStations() {
        List<Station> stations = Arrays.stream(initialStation)
                .map(Station::new)
                .collect(Collectors.toList());

        List<String> lineNames = Arrays.stream(initialLine)
                .collect(Collectors.toList());

        stations.stream().forEach(StationRepository::addStation);

        Line ihoseon = new Line(lineNames.get(0), stations.get(0), stations.get(1), stations.get(2));
        ihoseon.addDistanceList(Arrays.asList(2, 2));
        ihoseon.addTakeTimeList(Arrays.asList(3, 3));

        Line samhoseon = new Line(lineNames.get(1), stations.get(0), stations.get(3), stations.get(4), stations.get(6));
        samhoseon.addDistanceList(Arrays.asList(3, 6, 1));
        samhoseon.addTakeTimeList(Arrays.asList(2, 5, 1));

        Line sinboondang = new Line(lineNames.get(2), stations.get(1), stations.get(4), stations.get(5));
        sinboondang.addDistanceList(Arrays.asList(2, 10));
        sinboondang.addTakeTimeList(Arrays.asList(8, 3));

        LineRepository.addLine(ihoseon);
        LineRepository.addLine(samhoseon);
        LineRepository.addLine(sinboondang);
    }
}
