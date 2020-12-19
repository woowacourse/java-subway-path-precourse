package subway.view;

import java.util.Scanner;

public class InputView {

    public static final String FUNCTION_QUESTION = "원하는 기능을 선택하세요.";

    private static final String START_STATION_QUESTION = "출발역을 입력하세요.";

    private static final String END_STATION_QUESTION = "도착역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askFunction() {
        return ask(FUNCTION_QUESTION);
    }

    public String askStartStation() {
        return ask(START_STATION_QUESTION);
    }

    public String askEndStation() {
        return ask(END_STATION_QUESTION);
    }

    private String ask(String message) {
        System.out.printf("## %s\n\n", message);

        return scanner.nextLine();
    }
}
