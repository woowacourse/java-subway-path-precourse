package view;

import subway.domain.SectionRepository;

import java.util.List;

public class OutputView {
    private static final String MAIN_MESSAGE = "## 메인 화면";
    private static final String PATH_CHECK = "1. 경로조회";
    private static final String QUIT = "Q. 종료";
    private static final String PATH_STANDARD_MESSAGE = "## 경로 기준";
    private static final String SHORTEST_DISTANCE = "1. 최단 거리";
    private static final String SHORTEST_TIME = "2. 최소 시간";
    private static final String BACK = "B. 돌아가기";
    private static final String SHORTEST_PATH_RESULT = "## 조회 결과";
    private static final String DISTANCE = "[INFO] 총 거리: ";
    private static final String KILOMETER = "km";
    private static final String INFO = "[INFO] ";
    private static final String INFO_BORDER_LINE = "[INFO] ---";
    private static final String TIME = "[INFO] 총 소요 시간: ";
    private static final String MINUTE = "분";


    private OutputView() {
    }

    public static void printMainScreen() {
        System.out.println(MAIN_MESSAGE);
        System.out.println(PATH_CHECK);
        System.out.println(QUIT);
        System.out.println();
    }

    public static void printPathStandardSelectionScreen() {
        System.out.println();
        System.out.println(PATH_STANDARD_MESSAGE);
        System.out.println(SHORTEST_DISTANCE);
        System.out.println(SHORTEST_TIME);
        System.out.println(BACK);
        System.out.println();
    }

    public static void printShortestDistancePathResult(double shortestDistance, List shortestDistancePath) {
        int totalTime = 0;

        for (int i = 0; i < shortestDistancePath.size() - 1; i++) {
            totalTime += SectionRepository.getSectionTime(shortestDistancePath.get(i).toString(), shortestDistancePath.get(i+1).toString());
        }

        System.out.println(SHORTEST_PATH_RESULT);
        System.out.println(INFO_BORDER_LINE);
        System.out.println(DISTANCE + (int) shortestDistance + KILOMETER);
        System.out.println(TIME + totalTime + MINUTE);
        System.out.println(INFO_BORDER_LINE);

        for (Object path : shortestDistancePath) {
            System.out.println(INFO + path.toString());
        }
        System.out.println();
    }

    public static void printShortestTimePathResult(double shortestTime, List shortestTimePath) {
        int totalDistance = 0;

        for (int i = 0; i < shortestTimePath.size() - 1; i++) {
            totalDistance += SectionRepository.getSectionDistance(shortestTimePath.get(i).toString(), shortestTimePath.get(i+1).toString());
        }
        System.out.println(SHORTEST_PATH_RESULT);
        System.out.println(INFO_BORDER_LINE);
        System.out.println(DISTANCE + totalDistance + KILOMETER);
        System.out.println(TIME + (int) shortestTime + MINUTE);
        System.out.println(INFO_BORDER_LINE);

        for (Object path : shortestTimePath) {
            System.out.println(INFO + path.toString());
        }
        System.out.println();
    }
}
