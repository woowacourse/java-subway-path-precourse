package subway.view;

import java.util.List;
import subway.controller.Choice;

public class OutputView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    
    public static void printMenu(String title, List<Choice> choices) {
        System.out.println(ViewConstants.NEW_MESSAGE_PREFIX + title);
        for (Choice choice : choices) {
            System.out.println(choice.toString());
        }
        System.out.println(ViewConstants.EMPTY_LINE);
    }
    
    public static void printErrorMessage(Exception exception) {
        System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
        System.out.println(ViewConstants.EMPTY_LINE);
    }
}
