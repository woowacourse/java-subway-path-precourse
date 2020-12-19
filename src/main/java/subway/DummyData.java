package subway;

import subway.domain.*;

import java.util.Arrays;

public class DummyData {
    private final static Station STATION1 = new Station("교대역");
    private final static Station STATION2 = new Station("강남역");
    private final static Station STATION3 = new Station("역삼역");
    private final static Station STATION4 = new Station("남부터미널역");
    private final static Station STATION5 = new Station("양재역");
    private final static Station STATION6 = new Station("양재시민의숲역");
    private final static Station STATION7 = new Station("매봉역");
    private final static Line LINE1 = new Line("2호선");
    private final static Line LINE2 = new Line("3호선");
    private final static Line LINE3 = new Line("신분당선");


    public static void save() {
        StationRepository.addAllStation(Arrays.asList(
                STATION1, STATION2, STATION3, STATION4, STATION5, STATION6, STATION7
        ));
        LineRepository.addAllLine(Arrays.asList(
                LINE1, LINE2, LINE3
        ));
        LINE1.addSection(new Section(STATION1, STATION2, 2, 3));
        LINE1.addSection(new Section(STATION2, STATION3, 2, 3));
        LINE2.addSection(new Section(STATION1, STATION4, 3, 2));
        LINE2.addSection(new Section(STATION4, STATION5, 6, 5));
        LINE2.addSection(new Section(STATION5, STATION7, 1, 1));
        LINE3.addSection(new Section(STATION2, STATION5, 2, 8));
        LINE3.addSection(new Section(STATION5, STATION6, 10, 3));
    }
}
