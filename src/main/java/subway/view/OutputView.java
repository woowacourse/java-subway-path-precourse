package subway.view;

import org.jgrapht.GraphPath;

public class OutputView {
    private static final char NEW_LINE = '\n';

    public static void printMainMenu() {
        System.out.println(NEW_LINE+"## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public static void printSearchPathMenu() {
        System.out.println(NEW_LINE+"## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void printResult(GraphPath graphPath, GraphPath graphTime) {
        System.out.println("\n## 조회 결과");
        System.out.println("[INFO] 총 거리: " + graphPath.getWeight());
        System.out.println("[INFO] 총 소요 시간: " + graphTime.getWeight());
        System.out.println("[INFO] ---");
        System.out.println(graphPath.getEdgeList());
    }
}