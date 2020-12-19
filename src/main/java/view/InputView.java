package view;

import subway.domain.MainMenuType;

import java.util.Scanner;

public class InputView {
    private static final String SELECT_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String SELECT_FUNCTION_ERROR_MESSAGE = "[ERROR] 알 수 없는 기능입니다.";

    private InputView() {
    }

    public static MainMenuType inputFunctionNumber(Scanner scanner) {
        System.out.println(SELECT_FUNCTION_MESSAGE);
        return readLine(scanner);
    }

    private static MainMenuType readLine(Scanner scanner) {
        try {
            return MainMenuType.of(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(SELECT_FUNCTION_ERROR_MESSAGE);
            return inputFunctionNumber(scanner);
        }
    }
}
