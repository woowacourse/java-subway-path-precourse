package subway.view;

import java.util.List;

public class OutputView {
    private static final String LINE_SEPARATOR = "\n";

    private OutputView() {
    }

    public static void printMainMenu(List<String> menuNames) {
        OutputView.println("## 메인 화면");
        menuNames.stream()
                .forEach(OutputView::println);
        printLineSeparator();
    }

    public static void printLineSeparator() {
        print(LINE_SEPARATOR);
    }

    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }
}
