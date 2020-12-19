package outputview;

import java.awt.*;
import java.util.List;

public class FindView implements Output {
    public static void printFindMenu() {
        System.out.println(HEAD + PATH_CRITERIA);
        System.out.println(SHORTEST_LENGTH);
        System.out.println(SMALLEST_TIME);
        System.out.println(BACK);
        System.out.println();
    }

    public static void printStartStation() {
        System.out.println(HEAD + START_STATION);
    }

    public static void printEndStation() {
        System.out.println(HEAD + END_STATION);
    }

    public static void printResult(List<String> result, int length, int time) {
        if (!result.isEmpty()) {
            System.out.println(HEAD + FIND_RESULT);
            System.out.println(INFO + CONTOUR);
            System.out.printf(INFO + DISTANCE, length);
            System.out.printf(INFO + TIME, time);
            System.out.println(INFO + CONTOUR);
            for (String name : result) {
                System.out.println(INFO + name);
            }
            System.out.println();
        }
    }
}

