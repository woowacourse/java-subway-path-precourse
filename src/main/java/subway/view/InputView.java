package subway.view;

import subway.domain.CommandType;

import java.util.Scanner;

public class InputView {
    private static final String CHOICE_GUIDE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public CommandType inputCommandNumber() {
        System.out.println(CHOICE_GUIDE_MESSAGE);
        String userMessage = inputWithTrimming();
        lineFeed();
        return CommandType.of(userMessage);
    }

    private String inputWithTrimming() {
        return scanner.nextLine().trim();
    }

    private void lineFeed() {
        System.out.println();
    }
}
