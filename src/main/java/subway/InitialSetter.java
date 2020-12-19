package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.*;

public class InitialSetter {
    private static final List<String> STATION_NAME_LIST = Collections.unmodifiableList(
        Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역"));
    private static final List<String> LINE_NAME_LIST =
            Collections.unmodifiableList(Arrays.asList("2호선", "3호선", "신분당선"));

    private InitialSetter() {
    }

    public static void setupInitialInfo() {

    }


}
