package subway.util;

import subway.domain.Station;

import java.util.Arrays;
import java.util.List;

public class Initializer {
    private static final List<String> stations =
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

    public void init() {
        createStation();
    }

    public void createStation() {
        stations.forEach(Station::from);
    }

}
