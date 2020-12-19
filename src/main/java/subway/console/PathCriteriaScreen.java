package subway.console;

public class PathCriteriaScreen {
    private static final String PATH_CRITERIA_SCREEN_OUTPUT = "\n## 경로 기준\n1. 최단 거리\n2. 최소 시간\nB. 돌아가기";
    private static String pathCriteriaScreenInput;
    private static boolean isRightMenuInput = true;

    public static void startProcess() {
        do {
            printPathCriteriaScreenOutput();
            pathCriteriaScreenInput = Input.getPathCriteriaScreenInput();
            executeMenu();
        } while (!isRightMenuInput);
    }

    private static void executeMenu() {
        try {
            PathCriteriaMenu.executeMenuByInput(pathCriteriaScreenInput);
            isRightMenuInput = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            isRightMenuInput = false;
        }
    }

    private static void printPathCriteriaScreenOutput() {
        System.out.println(PATH_CRITERIA_SCREEN_OUTPUT);
    }
}
