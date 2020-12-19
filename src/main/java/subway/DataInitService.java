package subway;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class DataInitService {
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String SOUTH_TERMIANL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";
    private static final String LINE_TOW = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";

    public static void init() {
        //addStation();
        //addLine();
    }

    private static void addStation() {
        String[] StationNames = {GYODAE_STATION, GANGNAM_STATION, YEOKSAM_STATION,
            SOUTH_TERMIANL_STATION, YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION,
            MAEBONG_STATION};
        for (String stationName : StationNames) {
            StationService.addStation(stationName);
        }
    }

    private static void addLine() {
        String[] lineNames = {LINE_TOW, LINE_THREE, LINE_SINBUNDANG};
        for (String lineName : lineNames) {
            LineService.addLine(lineName);
        }
    }
}
