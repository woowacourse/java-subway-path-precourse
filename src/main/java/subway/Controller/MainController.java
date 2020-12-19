package subway.Controller;

import subway.menuSelection.MainMenuSelection;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private static boolean runFlag;

    public static void run() {
        runFlag = true;
        while (runFlag) {
            try {
                OutputView.printMainMenu();
                MainMenuSelection selection = InputView.getMainMenuSelection();
                selection.getMappedFunction().runMappedFunction();
            } catch (Exception e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public static void terminate() {
        runFlag = false;
    }
}
