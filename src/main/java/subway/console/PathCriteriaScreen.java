package subway.console;

public class PathCriteriaScreen {
    private static final String PATH_CRITERIA_SCREEN_OUTPUT = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    private static String pathCriteriaScreenInput;

    public static void startProcess() {
        printPathCriteriaScreenOutput();
        pathCriteriaScreenInput = Input.getPathCriteriaScreenInput();
        PathCriteriaMenu.executeMenuByInput(pathCriteriaScreenInput);
    }

    private static void printPathCriteriaScreenOutput() {
        System.out.println(PATH_CRITERIA_SCREEN_OUTPUT);
    }
}
