package subway.domain;

import java.util.*;

import static subway.utils.Constant.*;


public class InitSubway {

    public static void initSubway() {
        initStation();
        initLine();
    }

    private static void initStation() {
        List<String> stationStringList = new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        for (String stationName : stationStringList) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static void initLine() {
        Map<String, List<String>> lineMap = new HashMap<>();
        lineMap.put("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        lineMap.put("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        lineMap.put("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
        initAllLine(lineMap);
    }

    private static void initAllLine(Map<String, List<String>> lineMap) {
        for (String lineName : lineMap.keySet()) {
            if (lineName.equals(STRING_TWO_LINE)) {
                initLineByTwo(lineMap, lineName);
            }
            if (lineName.equals(STRING_THREE_LINE)) {
                initLineByThree(lineMap, lineName);
            }
            if (lineName.equals(STRING_SINBUNDANG_LINE)) {
                initLineBySinbundang(lineMap, lineName);
            }
        }
    }

    private static void initLineByTwo(Map<String, List<String>> lineMap, String lineName) {
        List<String> stationNames = lineMap.get(lineName);
        List<Station> stationsList = initTwoLineStations(stationNames);
        LineRepository.addLine(new Line(lineName, stationsList));
    }

    private static List<Station> initTwoLineStations(List<String> stationNames) {
        List<Station> stations = new ArrayList<>();
        List<Integer> stationDistanceInfo = new ArrayList<>(Arrays.asList(DEFAULT_TWO_DISTANCE, DEFAULT_TWO_DISTANCE));
        List<Integer> stationTimeInfo = new ArrayList<>(Arrays.asList(DEFAULT_THREE_TIME, DEFAULT_THREE_TIME));
        initLineStations(stationNames, stations, stationDistanceInfo, stationTimeInfo);

        return stations;
    }

    private static void initLineByThree(Map<String, List<String>> lineMap, String lineName) {
        List<String> stationNames = lineMap.get(lineName);
        List<Station> stationsList = initThreeLineStations(stationNames);
        LineRepository.addLine(new Line(lineName, stationsList));
    }

    private static List<Station> initThreeLineStations(List<String> stationNames) {
        List<Station> stations = new ArrayList<>();
        List<Integer> stationDistanceInfo = new ArrayList<>(Arrays.asList(DEFAULT_THREE_DISTANCE, DEFAULT_SIX_DISTANCE, DEFAULT_ONE_DISTANCE));
        List<Integer> stationTimeInfo = new ArrayList<>(Arrays.asList(DEFAULT_TWO_TIME, DEFAULT_FIVE_TIME, DEFAULT_ONE_TIME));
        initLineStations(stationNames, stations, stationDistanceInfo, stationTimeInfo);

        return stations;
    }

    private static void initLineBySinbundang(Map<String, List<String>> lineMap, String lineName) {
        List<String> stationNames = lineMap.get(lineName);
        List<Station> stationsList = initSinbundangLineStations(stationNames);
        LineRepository.addLine(new Line(lineName, stationsList));
    }

    private static List<Station> initSinbundangLineStations(List<String> stationNames) {
        List<Station> stations = new ArrayList<>();
        List<Integer> stationDistanceInfo = new ArrayList<>(Arrays.asList(DEFAULT_TWO_DISTANCE, DEFAULT_TEN_DISTANCE));
        List<Integer> stationTimeInfo = new ArrayList<>(Arrays.asList(DEFAULT_EIGHT_TIME, DEFAULT_THREE_TIME));
        initLineStations(stationNames, stations, stationDistanceInfo, stationTimeInfo);

        return stations;
    }

    private static void initLineStations(List<String> stationNames, List<Station> stations, List<Integer> stationDistanceInfo, List<Integer> stationTimeInfo) {
        for (int i = 0; i < stationNames.size(); i++) {
            if (i == 0) {
                stations.add(new Station(stationNames.get(i)));
                continue;
            }
            stations.add(new Station(stationNames.get(i), stationDistanceInfo.get(i - DISTANCE_INFO_LIST_INDEX), stationTimeInfo.get(i - TIME_INFO_LIST_INDEX)));
        }
    }
}
