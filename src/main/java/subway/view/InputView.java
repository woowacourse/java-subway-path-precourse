package subway.view;

import java.util.Scanner;
import subway.utils.InputValidator;

public class InputView {

    private static final String USER_OPTION_MESSAGE = "## 원하는 기능을 선택하세요";
    private static final String ERROR_PREFIX = "[ERROR]: ";
    private static Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputMainUserOption() {
        System.out.println(USER_OPTION_MESSAGE);
        String userOption = scanner.nextLine().trim();
        try {
            InputValidator.validateMainUserOption(userOption);
            return userOption;
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return inputMainUserOption();
        }
    }
}
