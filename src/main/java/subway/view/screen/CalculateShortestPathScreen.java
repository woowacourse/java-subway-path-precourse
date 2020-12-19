package subway.view.screen;

import subway.view.OutputView;

import java.util.Scanner;

public class CalculateShortestPathScreen {
    private static final String INPUT_SOURCE = "출발역을 입력하세요.";
    private static final String INPUT_DEST = "도착역을 입력하세요.";

    public static String inputSource(Scanner scanner) {
        OutputView.printGuide(INPUT_SOURCE);
        return scanner.nextLine();
    }

    public static String inputDest(Scanner scanner) {
        OutputView.printGuide(INPUT_DEST);
        return scanner.nextLine();
    }
}
