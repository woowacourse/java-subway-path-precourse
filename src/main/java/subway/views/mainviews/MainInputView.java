package subway.views.mainviews;

import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class MainInputView implements InputView{
    public static String inputMainOption(Scanner scanner) {
        OutputView.printSelectOptionMessage();
        return InputView.userInput(scanner);
    }
}
