package subway.view;

import java.util.Scanner;

public class MainMenuInputView {

    private static final String ROUTE_MENU = "1";
    private static final String QUIT_MENU = "Q";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";

    public static String getMainMenuCommand(Scanner scanner) {
        MainMenuOutputView.printMainMenu();
        try {
            String mainMenuCommand = scanner.nextLine();
            validateMainMenuCommand(mainMenuCommand);
            return mainMenuCommand;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return getMainMenuCommand(scanner);
        }
    }

    private static void validateMainMenuCommand(String menuCommand) {
        if (!menuCommand.equals(ROUTE_MENU) && !menuCommand.equals(QUIT_MENU)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
