package subway.view;

import subway.domain.StationBetween;
import subway.error.SubwayException;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static StationBetween getStationBetween() {
        try {
            OutputView.printNavi("출발역을 입력하세요.");
            String startName = scanner.nextLine();
            OutputView.printNavi("도착역을 입력하세요.");
            String endName = scanner.nextLine();
            return new StationBetween(startName, endName);
        } catch (SubwayException e) {
            OutputView.printError(e.getMessage());
            return getStationBetween();
        }
    }

    public static FunctionView getFunction() {
        try {
            OutputView.printNavi("원하는 기능을 선택하세요.");
            String key = scanner.nextLine();
            return FunctionView.getFunction(key);
        } catch (IllegalStateException e) {
            OutputView.printError(e.getMessage());
            return getFunction();
        }
    }

    public static MainView getMain() {
        try {
            OutputView.printNavi("원하는 기능을 선택하세요.");
            String key = scanner.nextLine();
            return MainView.getView(key);
        } catch (IllegalStateException e) {
            OutputView.printError(e.getMessage());
            return getMain();
        }
    }
}
