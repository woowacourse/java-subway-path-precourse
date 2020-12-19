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
    public static final String[] stationNames = {GYODAE_STATION, GANGNAM_STATION, YEOKSAM_STATION,
        SOUTH_TERMIANL_STATION, YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION,
        MAEBONG_STATION};
    private static final String LINE_TOW = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";
    private static int GYODAE_GANGNAM_DISTANCE = 2;
    private static int GYODAE_GANGNAM_TIME = 3;
    private static int GANGNAM_YEOKSAM_DISTANCE = 2;
    private static int GANGNAM_YEOKSAM_TIME = 3;
    private static int GYODAE_SOUTH_TERMINAL_DISTANCE = 3;
    private static int GYODAE_SOUTH_TERMINAL_TIME = 2;
    private static int SOUTH_TERMINAL_YANGJAE_DISTANCE = 6;
    private static int SOUTH_TERMINAL_YANGJAE_TIME = 5;
    private static int YANGJAE_MAEBONG_DISTANCE = 1;
    private static int YANGJAE_MAEBONG_TIME = 1;
    private static int GANGNAM_YANGJAE_DISTANCE = 2;
    private static int GANGNAM_YANGJAE_TIME = 8;
    private static int YANGJAE_YANGJAE_CITIZEN_FORESET_DISTANCE = 10;
    private static int YANGJAE_YANGJAE_CITIZEN_FORESET_TIME = 3;

    public static void init() {
        addStation();
        addLine();
        addConnectData();
    }

    private static void addStation() {
        for (String stationName : stationNames) {
            StationService.addStation(stationName);
        }
    }

    private static void addLine() {
        String[] lineNames = {LINE_TOW, LINE_THREE, LINE_SINBUNDANG};
        for (String lineName : lineNames) {
            LineService.addLine(lineName);
        }
        String[] lineTwoStations = {GYODAE_STATION, GANGNAM_STATION, YEOKSAM_STATION};
        String[] lineThreeStations = {GYODAE_STATION, SOUTH_TERMIANL_STATION, YANGJAE_STATION, MAEBONG_STATION};
        String[] lineSinbundangStations = {GANGNAM_STATION, YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION};
        addLineInStation(LINE_TOW, lineTwoStations);
        addLineInStation(LINE_THREE, lineThreeStations);
        addLineInStation(LINE_SINBUNDANG, lineSinbundangStations);
    }

    private static void addLineInStation(String lineName, String[] stationNames) {
        for (String stationName: stationNames) {
            LineService.lineInAddStation(lineName, stationName);
        }
    }

    private static void addConnectData() {
        StationService.stationAddConnectData(GYODAE_STATION, GANGNAM_STATION, GYODAE_GANGNAM_DISTANCE, GYODAE_GANGNAM_TIME);
        StationService.stationAddConnectData(GANGNAM_STATION, YEOKSAM_STATION, GANGNAM_YEOKSAM_DISTANCE, GANGNAM_YEOKSAM_TIME);
        StationService.stationAddConnectData(GYODAE_STATION, SOUTH_TERMIANL_STATION, GYODAE_SOUTH_TERMINAL_DISTANCE, GYODAE_SOUTH_TERMINAL_TIME);
        StationService.stationAddConnectData(SOUTH_TERMIANL_STATION, YANGJAE_STATION, SOUTH_TERMINAL_YANGJAE_DISTANCE, SOUTH_TERMINAL_YANGJAE_TIME);
        StationService.stationAddConnectData(YANGJAE_STATION, MAEBONG_STATION, YANGJAE_MAEBONG_DISTANCE, YANGJAE_MAEBONG_TIME);
        StationService.stationAddConnectData(GANGNAM_STATION, YANGJAE_STATION, GANGNAM_YANGJAE_DISTANCE, GANGNAM_YANGJAE_TIME);
        StationService.stationAddConnectData(YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION, YANGJAE_YANGJAE_CITIZEN_FORESET_DISTANCE, YANGJAE_YANGJAE_CITIZEN_FORESET_TIME);
    }
}
