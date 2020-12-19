package subway.subwaymanager;

import subway.utils.InputView;
import subway.utils.OutputView;

import static subway.utils.Constant.*;

public class MainSelectManager {

    public static void mainSelectManager() {
        boolean isContinue = true;
        while (isContinue) {
            OutputView.printMainContents();
            String inputMainSelect = InputView.inputSelect();
            isContinue = selectMenu(inputMainSelect);
        }
    }

    private static boolean selectMenu(String inputMainSelect) {
        if (inputMainSelect.equals(CONTENTS_NUMBER_FIRST)) {
            PathManager.pathChoice();
        }
        if (inputMainSelect.equals(CONTENTS_NUMBER_QUIT)) {
            OutputView.printEndMessage();
            return false;
        }
        return true;
    }
}
