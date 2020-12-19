package subway.view;

import java.util.Arrays;
import subway.view.mainview.MainChoice;
import subway.view.pathview.PathChoice;

public class OutputView {

    public static void printMainMenuInputGuideMessage() {
        Arrays.asList(MainChoice.values())
            .stream()
            .forEach(s -> System.out.println(s.toString()));
    }

    public static void printPathMenuInputGuideMessage() {
        Arrays.asList(PathChoice.values())
            .stream()
            .forEach(s -> System.out.println(s.toString()));
    }

    public static void printInputStartStationGuideMessage() {
        println(View.VIEW_PREFIX + "출발역을 입력하세요.");
    }

    public static void printInputEndStationGuideMessage() {
        println(View.VIEW_PREFIX + "도착역을 입력하세요.");
    }

    public static void println() {
        println();
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

}
