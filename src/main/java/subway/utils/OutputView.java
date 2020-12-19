package subway.utils;

import subway.domain.Path;

import java.util.List;

public class OutputView {

    public static void printMainContents() {
        System.out.println("메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println();
        System.out.println("원하는 기능을 선택하세요.");
    }

    public static void printEndMessage() {
        System.out.println("종료합니다.");
    }

    public static void printPathContents() {
        System.out.println("경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");

        System.out.println("원하는 기능을 선택하세요.");
    }

    public static void printResult(List<String> stationNames, List<Path> paths) {
        int sumDistance = sumDistance(paths);
        int sumTime = sumTime(paths);
        System.out.println("조회 결과");
        System.out.println("[INFO] ---");
        System.out.println(String.format("[INFO] 총 거리 : %s Km ", sumDistance));
        System.out.println(String.format("[INFO] 총 소요 시간 : %s 분", sumTime));
        System.out.println("[INFO] ---");
        for (String stationName : stationNames) {
            System.out.println("[INFO]  " + stationName);
        }
    }

    private static int sumDistance(List<Path> paths) {
        int sum = 0;
        for (Path path : paths) {
            sum += path.getDistance();
        }
        return sum;
    }

    private static int sumTime(List<Path> paths) {
        int sum = 0;
        for (Path path : paths) {
            sum += path.getTime();
        }
        return sum;
    }
}
