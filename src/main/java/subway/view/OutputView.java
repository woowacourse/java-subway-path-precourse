package subway.view;

import java.util.List;

import subway.exception.SubwayCustomException;

public class OutputView {

    private static final String MAIN_SCREEN = "## 메인 화면\n"
        + "1. 경로 조회\n"
        + "Q. 종료\n";

    private static final String TRAVERSE_SCREEN = "## 경로 기준\n"
        + "1. 최단 거리\n"
        + "2. 최소 시간\n"
        + "B. 돌아가기\n";

    public static void printTraverseScreen() {

        System.out.println();
        System.out.println(TRAVERSE_SCREEN);
    }

    public static void printMainScreen() {
        System.out.println();
        System.out.println(MAIN_SCREEN);
    }

    public static void printError(SubwayCustomException e) {
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
    }

    public static void printResult(List<String> shortestPath) {
        System.out.println();
        System.out.println("## 조회 결과");
        for (String path : shortestPath) {
            System.out.println("[INFO] " + path);
        }
    }
}
