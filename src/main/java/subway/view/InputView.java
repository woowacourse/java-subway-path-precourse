package subway.view;

import java.util.Objects;
import java.util.Scanner;
import subway.exception.NotInitScannerException;

public class InputView {

    private static InputView instance;
    private static final String PREFIX = "## ";
    private static final String INPUT_COMMAND_MESSAGE = PREFIX + "원하시는 기능을 선택하세요.";
    private static final String INPUT_START_MESSAGE = PREFIX + "출발역을 입력하세요.";
    private static final String INPUT_END_MESSAGE = PREFIX + "도착역을 입력하세요.";
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 빈 문자를 입력할 수 없습니다.";

    private Scanner scanner;


    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void initScanner(Scanner scanner) {
        instance = new InputView(scanner);
    }

    public static InputView getInstance() {
        if (instance == null) {
            throw new NotInitScannerException();
        }
        return instance;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private String inputData() {
        String input = scanner.nextLine();

        Objects.requireNonNull(input, INPUT_ERROR_MESSAGE);

        return input;
    }

    public String inputCommand() {
        printMessage(INPUT_COMMAND_MESSAGE);
        return inputData();
    }

    public String inputStartStation() {
        printMessage(INPUT_START_MESSAGE);
        return inputData();
    }

    public String inputEndStation() {
        printMessage(INPUT_END_MESSAGE);
        return inputData();
    }


}
