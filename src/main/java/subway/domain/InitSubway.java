package subway.domain;

import java.util.*;

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
            if (lineName.equals("2호선")) {
                initLineByTwo(lineMap, lineName);
            }
            if (lineName.equals("3호선")) {
                initLineByThree(lineMap, lineName);
            }
            if (lineName.equals("신분당선")) {
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
        List<Integer> stationDistanceInfo = new ArrayList<>(Arrays.asList(2, 2));
        List<Integer> stationTimeInfo = new ArrayList<>(Arrays.asList(3, 3));
        for (String stationName : stationNames) {
            stationLengthTwoTimeAndDistanceInit(stationNames, stations, stationDistanceInfo, stationTimeInfo, stationName);
        }
        return stations;
    }

    private static void initLineByThree(Map<String, List<String>> lineMap, String lineName) {
        List<String> stationNames = lineMap.get(lineName);
        List<Station> stationsList = initThreeLineStations(stationNames);
        LineRepository.addLine(new Line(lineName, stationsList));
    }

    private static List<Station> initThreeLineStations(List<String> stationNames) {
        List<Station> stations = new ArrayList<>();
        List<Integer> stationDistanceInfo = new ArrayList<>(Arrays.asList(3, 6, 1));
        List<Integer> stationTimeInfo = new ArrayList<>(Arrays.asList(2, 5, 1));
        for (String stationName : stationNames) {
            stationLengthThreeTimeAndDistanceInit(stationNames, stations, stationDistanceInfo, stationTimeInfo, stationName);
        }
        return stations;
    }

    private static void initLineBySinbundang(Map<String, List<String>> lineMap, String lineName) {
        List<String> stationNames = lineMap.get(lineName);
        List<Station> stationsList = initSinbundangLineStations(stationNames);
        LineRepository.addLine(new Line(lineName, stationsList));
    }

    private static List<Station> initSinbundangLineStations(List<String> stationNames) {
        List<Station> stations = new ArrayList<>();
        List<Integer> stationDistanceInfo = new ArrayList<>(Arrays.asList(2, 10));
        List<Integer> stationTimeInfo = new ArrayList<>(Arrays.asList(8, 3));
        for (String stationName : stationNames) {
            stationLengthTwoTimeAndDistanceInit(stationNames, stations, stationDistanceInfo, stationTimeInfo, stationName);
        }
        return stations;
    }

    private static void stationLengthTwoTimeAndDistanceInit(List<String> stationNames, List<Station> stations, List<Integer> stationDistanceInfo, List<Integer> stationTimeInfo, String stationName) {
        for (int i = 0; i < stationNames.size(); i++) {
            if (stationNames.size() == 2) {
                stations.add(new Station(stationName));
                break;
            }
            stations.add(new Station(stationName, stationDistanceInfo.get(i), stationTimeInfo.get(i)));
        }
    }

    private static void stationLengthThreeTimeAndDistanceInit(List<String> stationNames, List<Station> stations, List<Integer> stationDistanceInfo, List<Integer> stationTimeInfo, String stationName) {
        for (int i = 0; i < stationNames.size(); i++) {
            if (stationNames.size() == 3) {
                stations.add(new Station(stationName));
                break;
            }
            stations.add(new Station(stationName, stationDistanceInfo.get(i), stationTimeInfo.get(i)));
        }
    }
}
