package subway.view.path;

import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

import java.util.Arrays;

public class PathScreen {

    public static Boolean selectMenu() {
        showMenu();
        String input = InputView.inputFunction();
        if (!PathMenu.isValidInput(input)) {
            throw new SubwayException(TextCollection.WRONG_MENU_INPUT_MESSAGE);
        }
        PathMenu.findMenuByKey(input).request();
        return true;
    }

    private static void showMenu() {
        OutputView.printQuestion(TextCollection.SEARCH_MANAGEMENT_MESSAGE);
        Arrays.stream(PathMenu.values()).forEach(menu -> {
            System.out.println(menu.getKey() + ". " + menu.getTitle());
        });
    }
}
