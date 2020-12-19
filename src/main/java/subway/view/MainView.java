package subway.view;

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
        while(isContinuing) {
            try {
                mainOutputView.printMenu();
                String menuFeature = mainInputView.getMenuTargetFeature();
            } catch (IllegalArgumentException illegalArgumentException) {
                commonOutputView.printExceptionMessage(illegalArgumentException);
            }
        }
    }
}
