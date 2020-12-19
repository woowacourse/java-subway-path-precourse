package subway.view.output;

public class ErrorOutputView extends OutputView {
    private static String ERROR_SYMBOL = "\n[ERROR] ";
    private static String INVALID_MENU_INPUT = "선택할 수 없는 기능입니다.\n";
    private static String INVALID_STATION_INPUT = "잘못된 역 이름입니다.\n";
    private static String NOT_EXIST_STATION = "등록되지 않은 역입니다.\n";

    private static void errorSymbol() {
        stringBuilder.append(ERROR_SYMBOL);
    }

    private static void printError(String error) {
        errorSymbol();
        stringBuilder.append(error);
        print();
    }

    public static void invalidMenuInput() {
        printError(INVALID_MENU_INPUT);
    }

    public static void invalidStationName() {
        printError(INVALID_STATION_INPUT);
    }

    public static void notExistStation() {
        printError(NOT_EXIST_STATION);
    }
}
