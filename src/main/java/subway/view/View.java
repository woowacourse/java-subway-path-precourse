package subway.view;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import subway.Error;

public abstract class View {
    private static final String DEPARTURE_STATION_MESSAGE = "출발역을 입력하세요.";
    private static final String ARRIVAL_STATION_MESSAGE = "출발역을 입력하세요.";
    private static final String MENU_SELECTION_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String BORDER = "---\n";
    private static final String TOTAL_DISTANCE = "총 거리: ";
    private static final String TOTAL_TIME = "총 소요 시간: ";
    private static final String RESULT_TITLE = "조회 결과";
    private static final String INFO_FORM = "[INFO] %s\n";
    private static final String ERROR_FORM = "[ERROR] %s\n";
    protected static final String TITLE_FORM = "## %s\n";
    protected static final String MENU_FORM = "%s. %s\n";
    protected final Scanner scanner;
    protected final PrintStream printStream;

    protected View(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    abstract void printTitle();

    abstract void printMenuList();

    public String requestDepartureStation() {
        printStream.printf(TITLE_FORM, DEPARTURE_STATION_MESSAGE);
        String input = scanner.nextLine();
        printStream.println();
        return input;
    }

    public String requestArrivalStation() {
        printStream.printf(TITLE_FORM, ARRIVAL_STATION_MESSAGE);
        String input = scanner.nextLine();
        printStream.println();
        return input;
    }

    public String requestMenu() {
        printTitle();
        printMenuList();
        printStream.printf(TITLE_FORM, MENU_SELECTION_MESSAGE);
        String input = scanner.nextLine();
        printStream.println();
        return input;
    }

    public void printPath(List<String> names) {
        printStream.printf(TITLE_FORM, RESULT_TITLE);
        printStream.print(BORDER);
        printStream.printf(INFO_FORM, TOTAL_DISTANCE);
        printStream.printf(INFO_FORM, TOTAL_TIME);
        printStream.print(BORDER);
        for (String name : names) {
            printStream.printf(INFO_FORM, name);
        }
        printStream.println();
    }

    public void printError(Error error) {
        printStream.printf(ERROR_FORM, error.getMessage());
        printStream.println();
    }
}
