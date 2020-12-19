package subway.view;

import subway.domain.Distance;
import subway.domain.Station;
import subway.domain.Time;

import java.util.List;

public class OutputView {
    private static final String LINE_BREAK = "\n";
    private static final String INFO_MESSAGE = "[INFO] %s";
    private static final String ERROR_MESSAGE = "[ERROR] %s";
    private static final String LINE_SEPARATOR = "---";
    private static final String TAKEN_DISTANCE_MESSAGE = "총 거리 : %s %s";
    private static final String TAKEN_TIME_MESSAGE = "총 소요 시간 : %s %s";

    private OutputView() {
    }

    public static void printSearchResult(List<Station> path, int takenDistance, int takenTime) {
        println("## 조회 결과");
        printInfo(LINE_SEPARATOR);
        printTakenDistance(takenDistance);
        printTakenTime(takenTime);
        printInfo(LINE_SEPARATOR);
        printPath(path);
        printLineBreak();
    }

    private static void printPath(List<Station> path) {
        path.stream().forEach(station -> printInfo(station));
    }

    private static void printTakenDistance(int takenDistance) {
        printInfo(String.format(TAKEN_DISTANCE_MESSAGE, takenDistance, Distance.unit));
    }

    private static void printTakenTime(int takenTime) {
        printInfo(String.format(TAKEN_TIME_MESSAGE, takenTime, Time.unit));
    }

    public static void printMainMenu(List<String> menuNames) {
        OutputView.println("## 메인 화면");
        menuNames.stream()
                .forEach(OutputView::println);
        printLineBreak();
    }

    public static void printSearchMenu(List<String> menuNames) {
        OutputView.println("## 경로 기준");
        menuNames.stream()
                .forEach(OutputView::println);
        printLineBreak();
    }

    public static void printInfo(Object msg) {
        printf(INFO_MESSAGE, msg);
        printLineBreak();
    }

    public static void printError(Exception e) {
        printf(ERROR_MESSAGE, e.getMessage());
        printLineBreak();
    }

    public static void printLineBreak() {
        print(LINE_BREAK);
    }

    public static void printf(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }
}
