package subway.view;

import subway.domain.SceneState;
import subway.domain.station.Station;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String INFO = "[INFO] ";
    private static final String INFO_LINE = INFO + "---";
    private static final String SECTION_EMPTY_ERROR_MESSAGE = "[ERROR] 연결된 구간이 없는 역입니다.";
    private static final String STATION_ERROR_MESSAGE = "[ERROR] 존재하지 않는 역입니다.";
    private static final String SAME_STATION_ERROR_MESSAGE = "[ERROR] 출발역과 도착역은 동일하면 안됩니다.";

    public static void printMainScene() {
        System.out.println(NEW_LINE + "## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void printPathScene() {
        System.out.println(NEW_LINE + "## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static SceneState printInquiryDistanceResult(List<Station> stations, int distance) {
        if (stations == null) {
            return SceneState.MAIN_SCENE;
        }

        System.out.println(NEW_LINE + INFO_LINE);
        System.out.println(INFO + "총 거리: " + distance + "km");
        System.out.println(INFO_LINE);

        return printStations(stations);
    }

    public static SceneState printInquiryTimeResult(List<Station> stations, int time) {
        if (stations == null) {
            return SceneState.MAIN_SCENE;
        }

        System.out.println(NEW_LINE + INFO_LINE);
        System.out.println(INFO + "총 소요 시간: " + time + "분");
        System.out.println(INFO_LINE);

        return printStations(stations);
    }

    private static SceneState printStations(List<Station> stations) {
        stations.forEach(station -> System.out.println(INFO + station.getName()));

        return SceneState.MAIN_SCENE;
    }

    public static void printSectionEmptyErrorMessage() {
        System.out.println(SECTION_EMPTY_ERROR_MESSAGE);
    }

    public static void printStationErrorMessage() {
        System.out.println(STATION_ERROR_MESSAGE);
    }

    public static void printSameStationErrorMessage() {
        System.out.println(SAME_STATION_ERROR_MESSAGE);
    }
}
