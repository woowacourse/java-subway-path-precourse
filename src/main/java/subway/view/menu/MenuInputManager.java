package subway.view.menu;

import java.util.Scanner;
import subway.common.ErrorCustomException;
import subway.common.ErrorMessage;
import subway.domain.Menu;

public class MenuInputManager {
    private static final String INPUT_NEEDED = " 중에서 입력해 주세요.";
    private final Scanner scanner;

    public MenuInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMainInput() {
        MenuOutputManager.printWhichMenuGuide();
        String inputKey = scanner.nextLine().toUpperCase().trim();
        try {
            checkMainSelection(inputKey);
        } catch (ErrorCustomException error) {
            ErrorMessage.print(error);
            return ErrorMessage.OUT;
        }
        return inputKey;
    }

    public String getPathInput() {
        MenuOutputManager.printWhichMenuGuide();
        String inputKey = scanner.nextLine().toUpperCase().trim();
        try {
            checkPathSelection(inputKey);
        } catch (ErrorCustomException error) {
            ErrorMessage.print(error);
            return ErrorMessage.OUT;
        }
        return inputKey;
    }

    private void checkMainSelection(String input) {
        if (!Menu.MAIN.containsKey(input)) {
            throw new ErrorCustomException(Menu.MAIN.getStringMenuKeys() + INPUT_NEEDED);
        }
    }

    private void checkPathSelection(String input) {
        if (!Menu.SEARCH_PATH.containsKey(input)) {
            throw new ErrorCustomException(Menu.SEARCH_PATH.getStringMenuKeys() + INPUT_NEEDED);
        }
    }

}
