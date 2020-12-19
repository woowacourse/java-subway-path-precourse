package subway;

public class PathCriteriaSelectionScreenPrinter {
    private static final String screenMenu
        = "\n## 경로 기준\n"
        + "1. 최단 거리\n"
        + "2. 최소 시간\n"
        + "B. 돌아가기";

    public static void printMenu() {
        System.out.println(screenMenu);
    }
}
