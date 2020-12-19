package subway.controller;

import subway.domain.MenuRepository;
import subway.userinterface.ErrorOutput;
import subway.userinterface.Input;

public class UserController {
    public static void start() {
        InitializingManager.initialize();
        boolean runStatus = true;
        while (runStatus) {
            Input.printMainMenu();
            runStatus = startMainMenu();
        }
    }

    private static boolean startMainMenu() {
        String input = Input.newInput().toUpperCase();
        if (ErrorOutput.isWrongMainMenuInput(input)) {
            return true;
        }

        for (String key : MenuRepository.mainMenu.keySet()) {
            if (input.equals(key)) {
                MenuRepository.mainMenu.get(key).run();
                return true;
            }
        }
        return false;
    }
}
