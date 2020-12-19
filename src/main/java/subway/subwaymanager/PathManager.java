package subway.subwaymanager;

import subway.utils.InputView;
import subway.utils.OutputView;

import static subway.utils.Constant.*;
import static subway.utils.Constant.CONTENTS_NUMBER_BACK;

public class PathManager {

    public static void pathChoice() {
        boolean isContinue = true;
        while (isContinue) {
            OutputView.printPathContents();
            String inputPathSelect = InputView.inputSelect();
            isContinue = selectPath(inputPathSelect);
        }
    }

    private static boolean selectPath(String inputPathSelect) {
        if (inputPathSelect.equals(CONTENTS_NUMBER_FIRST)) {
        }
        if (inputPathSelect.equals(CONTENTS_NUMBER_SECOND)) {
        }
        if (inputPathSelect.equals(CONTENTS_NUMBER_BACK)) {
            return false;
        }
        return true;
    }
}
