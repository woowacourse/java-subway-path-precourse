package subway;

import subway.domain.*;
import subway.exception.GraphNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subway {

    private static final String TITLE = "## 메인 화면";

    private static final String INQUIRY_SELECTION = "1";
    private static final String QUIT_SELECTION = "Q";


    private static final String INQUIRY_DESCRIPTION = "경로 조회";
    private static final String QUIT_DESCRIPTION = "종료";

    private static final List<String> SELECTIONS = List.of(INQUIRY_SELECTION, QUIT_SELECTION);

    private static final String MENU = TITLE + "\n" + INQUIRY_SELECTION + ". " + INQUIRY_DESCRIPTION + "\n" +
            QUIT_SELECTION + ". " + QUIT_DESCRIPTION;

    private static final String CHOOSE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private static final String NOT_VALID_INPUT_ERROR = "[ERROR] 그 기능은 사용할 수 없습니다.";

    private static final List<String> INIT_LINES = List.of("2호선:교대역-강남역-역삼역", "3호선:교대역-남부터미널역-양재역-매봉역", "신분당선:강남역-양재역-양재시민의숲역");
    private static final List<String> INIT_WEIGHTS =
            List.of("교대역:강남역=2/3", "강남역:역삼역=2/3", "교대역:남부터미널역=3/2", "남부터미널역:양재역=6/5", "양재역:매봉역=1/1",
                    "강남역:양재역=2/8", "양재역:양재시민의숲역=10/3");

    private final Scanner scanner;
    private final GraphMenu graphMenu;

    public Subway(Scanner scanner) {
        this.scanner = scanner;
        this.graphMenu = new GraphMenu(scanner);
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
                graphMenu.printMenu();
            }
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


}
