package controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayPathChecker {
    private static final String LINE_NUMBER_TWO = "2호선";
    private static final String LINE_NUMBER_THREE = "3호선";
    private static final String LINE_NEW_BOONDANG = "신분당선";
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";

    public SubwayPathChecker() {
        registerLine();
//        registerStation();
//        insertStationToLine();
    }

    public void run() {

    }
    
    private void registerLine() {
        LineRepository.addLine(new Line(LINE_NUMBER_TWO));
        LineRepository.addLine(new Line(LINE_NUMBER_THREE));
        LineRepository.addLine(new Line(LINE_NEW_BOONDANG));
    }
}
