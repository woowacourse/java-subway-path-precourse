package subway.view;

import java.util.Arrays;
import subway.view.mainview.MainChoice;

public class OutputView {

    public static void printMainMenuInputGuideMessage() {
        Arrays.asList(MainChoice.values())
            .stream()
            .forEach(s -> System.out.println(s.toString()));
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
