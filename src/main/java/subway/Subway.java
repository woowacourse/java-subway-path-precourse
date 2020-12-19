package subway;

import subway.controller.GraphController;
import subway.domain.*;
import subway.exception.GraphNotExistException;

import java.util.*;

public class Subway {

    // 메인 화면 변수
    private static final String TITLE = "## 메인 화면";

    private static final String INQUIRY_SELECTION = "1";
    private static final String QUIT_SELECTION = "Q";

    private static final String INQUIRY_DESCRIPTION = "경로 조회";
    private static final String QUIT_DESCRIPTION = "종료";

    private static final List<String> SELECTIONS = List.of(INQUIRY_SELECTION, QUIT_SELECTION);

    private static final String MENU = TITLE + "\n" + INQUIRY_SELECTION + ". " + INQUIRY_DESCRIPTION + "\n" +
            QUIT_SELECTION + ". " + QUIT_DESCRIPTION;

    // 서브 메뉴 변수
    private static final String SUB_HELLO = "## 경로 기준";

    private static final String DISTANCE_SELECTION = "1";
    private static final String TIME_SELECTION = "2";
    private static final String BACK_SELECTION = "B";

    private static final List<String> SUB_SELECTIONS = List.of(DISTANCE_SELECTION, TIME_SELECTION, BACK_SELECTION);

    private static final String DISTANCE_DESCRIPTION = "최단 거리";
    private static final String TIME_DESCRIPTION = "최소 시간";
    private static final String BACK_DESCRIPTION = "돌아가기";

    private static final String SUB_MENU = SUB_HELLO + "\n" + DISTANCE_SELECTION + ". " + DISTANCE_DESCRIPTION + "\n" +
            TIME_SELECTION + ". " + TIME_DESCRIPTION + "\n" + BACK_SELECTION + ". " + BACK_DESCRIPTION;

    private static final String CHOOSE_START_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String CHOOSE_END_STATION_MESSAGE = "## 도착역을 입력하세요.";

    private static final String RESULT_MESSAGE = "## 조회 결과";

    private static final String INFO = "[INFO]";

    private static final String TOTAL_DISTANCE = "총 거리";
    private static final String TOTAL_TIME = "총 소요 시간";

    // 공통 변수
    private static final String CHOOSE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private static final List<String> INIT_LINES = List.of("2호선:교대역-강남역-역삼역", "3호선:교대역-남부터미널역-양재역-매봉역", "신분당선:강남역-양재역-양재시민의숲역");
    private static final List<String> INIT_WEIGHTS =
            List.of("교대역:강남역=2/3", "강남역:역삼역=2/3", "교대역:남부터미널역=3/2", "남부터미널역:양재역=6/5", "양재역:매봉역=1/1",
                    "강남역:양재역=2/8", "양재역:양재시민의숲역=10/3");

    private static final String NOT_VALID_INPUT_ERROR = "[ERROR] 그 기능은 사용할 수 없습니다.";
    private static final String STATION_NOT_EXIST_ERROR = "[ERROR] 출발역과 도착역 중에 없는 역이 존재합니다.";
    private static final String SAME_TERMINAL_ERROR = "[ERROR] 출발역과 도착역이 같습니다.";

    private static final Map<String, GraphType> MAPPING = new HashMap<>();

    private final Scanner scanner;
    private final GraphController graphController = new GraphController();


    public Subway(Scanner scanner) {
        this.scanner = scanner;
        for (String line : INIT_LINES) {
            String[] split = line.split(":");

            String[] stationNames = split[1].split("-");
            saveStations(stationNames);

            String lineName = split[0];
            saveLines(lineName);
        }
        GraphRepository.addGraph(GraphType.TIME);
        GraphRepository.addGraph(GraphType.DISTANCE);
        saveStationWeight();
        setMapping();
    }

    private void setMapping() {
        MAPPING.put(DISTANCE_SELECTION, GraphType.DISTANCE);
        MAPPING.put(TIME_SELECTION, GraphType.TIME);
    }

    public void printMenu() {
        while (true) {
            System.out.println(MENU + "\n" + CHOOSE_MESSAGE);
            String select = scanner.next();

            if (!validInput(select)) {
                System.out.println(NOT_VALID_INPUT_ERROR + "\n");
            } else if (select.equals(QUIT_SELECTION)) {
                break;
            } else if(select.equals(INQUIRY_SELECTION)) {
                printSubMenu();
            }
        }
    }

    private void printSubMenu() {
        while (true) {
            System.out.println(SUB_MENU + "\n" + CHOOSE_MESSAGE);
            String select = scanner.next();

            if (!SUB_SELECTIONS.contains(select)) {
                System.out.println(NOT_VALID_INPUT_ERROR + "\n");
                continue;
            } else if (select.equals(BACK_SELECTION)) {
                break;
            }

            printPath(MAPPING.get(select));
            break;
        }
    }

    private void printPath(GraphType graphType) {

        System.out.println(CHOOSE_START_STATION_MESSAGE);
        String startStationName = scanner.next();
        System.out.println("\n" + CHOOSE_END_STATION_MESSAGE);
        String endStationName = scanner.next();

        if (checkValid(startStationName, endStationName)) {
            System.out.println(resultToString(graphController.getGraphInfo(startStationName, endStationName, graphType)));
        }

    }

    private boolean validInput(String select) {
        if (SELECTIONS.contains(select)) {
            return true;
        }

        return false;
    }

    private void saveStationWeight() {
        for (String connection : INIT_WEIGHTS) {

            String[] split = connection.split("=");
            List<Station> stations = getStations(split[0].split(":"));

            String[] weights = split[1].split("/");

            String distance = weights[0];
            String time = weights[1];

            makeConnection(stations, distance, time);
        }
    }

    private void makeConnection(List<Station> stations, String distance, String time) {
        try {

            GraphRepository.findGraphByType(GraphType.TIME).makeConnection(stations.get(0), stations.get(1), Integer.parseInt(time));
            GraphRepository.findGraphByType(GraphType.DISTANCE).makeConnection(stations.get(0), stations.get(1), Integer.parseInt(distance));

        } catch (GraphNotExistException e) {
            // error
            System.out.println(e.getMessage());
        }
    }

    private List<Station> getStations(String[] stations) {
        List<Station> stationList = new ArrayList<>();
        for (String stationName : stations) {
            stationList.add(StationRepository.findStationByName(stationName));
        }

        return stationList;
    }

    private void saveLines(String lineName) {
        LineRepository.addLine(new Line(lineName));
    }

    private void saveStations(String[] stations) {
        for (String stationName : stations) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    public String resultToString(GraphDTO dto) {

        StringBuilder sb = new StringBuilder();

        sb.append(RESULT_MESSAGE).append("\n").append(INFO).append(" ---\n");
        sb.append(INFO).append(" ").append(TOTAL_DISTANCE).append(": ").append(dto.getDistance()).append("km\n");

        sb.append(INFO).append(" ").append(TOTAL_TIME).append(": ").append(dto.getTime()).append("분\n");
        sb.append(INFO).append(" ---\n");

        for (Station station : dto.getPath()) {
            sb.append(INFO).append(" ").append(station.getName()).append("\n");
        }
        return sb.toString();
    }

    public boolean checkValid(String startStationName, String endStationName) {

        if (!StationRepository.contains(startStationName) || !StationRepository.contains(endStationName)) {
            System.out.println(STATION_NOT_EXIST_ERROR + "\n");
            return false;
        } else if (startStationName.equals(endStationName)) {
            System.out.println(SAME_TERMINAL_ERROR + "\n");
            return false;
        }
        return true;
    }


}
