package subway.view;

import subway.domain.StationBetween;
import subway.error.SubwayException;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String START_STATION = "출발역을 입력하세요.";
    private static final String END_STATION = "도착역을 입력하세요.";
    private static final String SELECT_FUNCTION = "원하는 기능을 선택하세요.";

    public static StationBetween getStationBetween() {
        try {
            OutputView.printNavi(START_STATION);
            String startName = scanner.nextLine();
            OutputView.printNavi(END_STATION);
            String endName = scanner.nextLine();
            return new StationBetween(startName, endName);
        } catch (SubwayException e) {
            OutputView.printError(e.getMessage());
            return getStationBetween();
        }
    }

    public static FunctionView getFunction() {
        try {
            OutputView.printNavi(SELECT_FUNCTION);
            String key = scanner.nextLine();
            return FunctionView.getFunction(key);
        } catch (IllegalStateException e) {
            OutputView.printError(e.getMessage());
            return getFunction();
        }
    }

    public static MainView getMain() {
        try {
            OutputView.printNavi(SELECT_FUNCTION);
            String key = scanner.nextLine();
            return MainView.getView(key);
        } catch (IllegalStateException e) {
            OutputView.printError(e.getMessage());
            return getMain();
        }
    }
}
