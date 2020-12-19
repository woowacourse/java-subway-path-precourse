package subway.view;

import subway.util.MainViewUtil;
import subway.view.input.MainInputView;
import subway.view.output.CommonOutputView;
import subway.view.output.MainOutputView;

import java.util.Scanner;

public class MainView {
    MainInputView mainInputView;
    MainOutputView mainOutputView;
    CommonOutputView commonOutputView;

    public MainView(Scanner scanner) {
        mainInputView = new MainInputView(scanner);
        mainOutputView = new MainOutputView();
        commonOutputView = new CommonOutputView();
    }

    public void render() {
        boolean isContinuing = true;
        while (isContinuing) {
            try {
                mainOutputView.printMenu();
                String menuFeature = mainInputView.getMenuTargetFeature();
                checkAndRunSwitchViewToRouteLookupView(menuFeature);
                isContinuing = checkAndQuitApplication(menuFeature);
            } catch (IllegalArgumentException illegalArgumentException) {
                commonOutputView.printExceptionMessage(illegalArgumentException);
            }
        }
    }

    public void checkAndRunSwitchViewToRouteLookupView(String menuFeature) {
        if (!menuFeature.equals(MainViewUtil.getBtnSelectPath())) {
            return;
        }
    }

    public boolean checkAndQuitApplication(String menuFeature) {
        if (!menuFeature.equals(MainViewUtil.getBtnExit())) {
            return true;
        }
        return false;
    }
}
