package subway.view;

import subway.controller.SubwayMessage;

import java.util.List;
import java.util.Scanner;

public class SubwayView {
    private static final String SEARCH_RESULT = "## 조회 결과\n";
    private static final String DASH_DIVIDER = "---\n";
    private static final String INFO_PREFIX = "[INFO] ";

    private Scanner scanner;

    public SubwayView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String userInput() {
        String userInput = scanner.nextLine();
        newLine();
        return userInput;
    }

    public void printMessage(SubwayMessage subwayMessage) {
        System.out.print(subwayMessage.getContent());
    }

    public void newLine() {
        System.out.println();
    }

    public void printResult(List<String> stationList) {
        System.out.print(SEARCH_RESULT);
        System.out.print(INFO_PREFIX + DASH_DIVIDER);
        for (String station : stationList) {
            System.out.println(INFO_PREFIX + station);
        }
        newLine();
    }
}
