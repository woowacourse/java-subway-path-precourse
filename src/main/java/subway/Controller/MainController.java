package subway.Controller;

import subway.menuSelection.MainMenuSelection;
import subway.menuSelection.PathStandardSelection;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private static boolean runFlag;
    private static boolean standardSelecitionRunFlag;

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

    public static void connectToInquiryPath() {
        standardSelecitionRunFlag = true;

        while (standardSelecitionRunFlag) {
            try {
                OutputView.printPathStandardSelectionMenu();
                PathStandardSelection selection = InputView.getPathStandardSelection();
                selection.getMappedFunction().runMappedFunction();
            } catch (Exception e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    public static void backToMainScreen() {
        standardSelecitionRunFlag = false;
    }
}
