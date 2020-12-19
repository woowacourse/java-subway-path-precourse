package subway.view.output;

import java.util.List;

public class RouteOutputView extends OutputView {
    private static String ROUTE_VIEW = "경로 기준\n";
    private static String INPUT_FIRST_STATION = "출발역을 입력하세요.\n";
    private static String INPUT_LAST_STATION = "도착역을 입력하세요\n";
    private static String RESULT = "조회 결과\n";
    private static String LINE = "---";
    private static String WHOLE_DISTANCE = "총 거리 : ";
    private static String KILOMETER = "km";
    private static String WHOLE_TIME = "총 소요 시간: ";
    private static String MINUTE = "분";
    private static String NEXT_LINE = "\n";

    public void printRouteMenu(List<String> list) {
        printMenu(ROUTE_VIEW, list);
    }

    public void printFirstStation() {
        menuSymbol();
        stringBuilder.append(INPUT_FIRST_STATION);
        print();
    }

    public void printLastStation() {
        menuSymbol();
        stringBuilder.append(INPUT_LAST_STATION);
        print();
    }

    public void printRoute(int distance, int time, List<String> paths) {
        printResult();
        printLine();
        infoSymbol();
        stringBuilder.append(WHOLE_DISTANCE + distance + KILOMETER);
        infoSymbol();
        stringBuilder.append(WHOLE_TIME + time + MINUTE);
        printLine();
        paths.stream()
                .forEach(path -> {
                    infoSymbol();
                    stringBuilder.append(path);
                });
        stringBuilder.append(NEXT_LINE);
        print();
    }

    private void printResult() {
        menuSymbol();
        stringBuilder.append(RESULT);
    }

    private void printLine() {
        infoSymbol();
        stringBuilder.append(LINE);
    }
}
