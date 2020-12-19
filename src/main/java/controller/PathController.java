package controller;

import java.util.Arrays;
import subway.domain.Path;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

public class PathController {
    private static final String DOT = ". ";
    private static final String SELECT_FUCTION = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_START_STATION = "## 출발역을 입력하세요.";
    private static final String INPUT_DESTINATION_STATION = "## 도착역을 입력하세요.";

    private static final String INFO_PREFIX = "[INFO] ";
    private static final String DASH = "---";
    private static final String TOTAL_DISTANCE = "총 거리: ";
    private static final String TOTAL_TIME = "총 소요 시간: ";
    private static final String KM = "km";
    private static final String MINUTE = "분";

    public void run() {
        showMenu();
        String input = InputView.inputWithHintMessage(SELECT_FUCTION);
        if (input.equals(PathMenu.GO_BACK.getValue())) {
            return;
        }
        processInput(input);
        OutputView.printNewLine();
    }

    private void showMenu() {
        OutputView.print(PathMenu.MENU_NAME);
        Arrays.stream(PathMenu.values()).forEach(
                pathMenu -> OutputView.print(pathMenu.getValue() + DOT + pathMenu.getAction()));
        OutputView.printNewLine();
    }

    private void processInput(String input) {
        String from = InputView.inputWithHintMessage(INPUT_START_STATION);
        String to = InputView.inputWithHintMessage(INPUT_DESTINATION_STATION);
        Path path = new Path(StationRepository.getStationByName(from),
                StationRepository.getStationByName(to));
        if (!path.validatePath()) {
            return;
        }
        if (input.equals(PathMenu.PIVOT_SHORTEST_DISTANCE.getValue())) {
            printResult(path.getShortestDistance(), path.getShortestTime());
        }
        if (input.equals(PathMenu.PIVOT_SHORTEST_TIME.getValue())) {
            printResult(path.getShortestDistance(), path.getShortestTime());
        }
    }

    private void printResult(int distance, int time) {
        OutputView.print(INFO_PREFIX + DASH);
        OutputView.print(INFO_PREFIX + TOTAL_DISTANCE + distance + KM);
        OutputView.print(INFO_PREFIX + TOTAL_TIME + time + MINUTE);
        OutputView.print(INFO_PREFIX + DASH);
    }

}
