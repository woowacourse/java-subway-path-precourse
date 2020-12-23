package subway.views.mainviews;

import subway.views.OutputView;

import java.util.Scanner;

public class MainInputView {
    private MainInputView() {
    }

    public static String inputMainOption(Scanner scanner) {
        OutputView.printSelectOptionMessage();
        return scanner.nextLine();
    }
}
