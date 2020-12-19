package subway.view;

import subway.view.input.MainInputView;
import subway.view.output.MainOutputView;

import java.util.Scanner;

public class MainView {
    MainInputView mainInputView;
    MainOutputView mainOutputView;

    public MainView(Scanner scanner) {
        mainInputView = new MainInputView(scanner);
        mainOutputView = new MainOutputView();
    }

    public void render() {
        mainOutputView.printMenu();
        String menuFeature = mainInputView.getTargetFeature();
    }
}
