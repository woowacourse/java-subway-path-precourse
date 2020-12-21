package subway.view;

import subway.Menu.Menu;
import subway.PathResult;

import java.util.List;

public class OutputView {

    private static final String newLine = "\n";

    public static void printMainMenu() {
        String message = "## 메인 화면" + newLine;
        for (Menu.Main menu : Menu.Main.values()) {
            message += String.format("%s. %s" + newLine, menu.getCode(), menu.getKorean());
        }
        System.out.println(message);
    }

    public static void printCriteriaMenu() {
        String message = "## 경로 기준" + newLine;
        for (Menu.ROUTE_CRITERIA menu : Menu.ROUTE_CRITERIA.values()) {
            message += String.format("%s. %s" + newLine, menu.getCode(), menu.getKorean());
        }
        System.out.println(message);
    }

    public static void printRouteResult(PathResult pathResult) {
        List<String> shortestPath = pathResult.getShortestPath();
        int shortestPathDistance = pathResult.getDistance();
        int requiredTime = pathResult.getRequiredTime();

        System.out.println();
        System.out.println("## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println(String.format("[INFO] 총 거리: %dkm", shortestPathDistance));
        System.out.println(String.format("[INFO] 총 소요시간: %d분", requiredTime));
        System.out.println("[INFO] ---");
        shortestPath.stream()
                .forEach(station -> System.out.println("[INFO] " + station));
        System.out.println();
    }
}
