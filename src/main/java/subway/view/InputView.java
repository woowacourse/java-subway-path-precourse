package subway.view;

import subway.utils.InputValidator;
import subway.utils.exception.InvalidMenuInputException;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;
    private static InputValidator inputValidator = new InputValidator();

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String selectMenu() {
        try {
            String menu = scanner.nextLine();
            inputValidator.invalidMenu(menu);
            return menu;
        } catch (InvalidMenuInputException e) {
            throw new NullPointerException();
        }
    }
}
