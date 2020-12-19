package subway.Controller;

public class MainController {
    private static boolean runFlag;

    public static void run() {
        runFlag = true;
        while (runFlag) {

        }
    }

    public static void terminate() {
        runFlag = false;
    }
}
