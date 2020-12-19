package subway.view;

import subway.view.input.RouteLookupInputView;
import subway.view.output.CommonOutputView;
import subway.view.output.RouteLookupOutputView;

import java.util.Scanner;

public class RouteLookupView {
    RouteLookupInputView routeLookupInputView;
    RouteLookupOutputView routeLookupOutputView;
    CommonOutputView commonOutputView;

    public RouteLookupView(Scanner scanner) {
        routeLookupInputView = new RouteLookupInputView(scanner);
        routeLookupOutputView = new RouteLookupOutputView();
        commonOutputView = new CommonOutputView();
    }

    public void render() {
        while (true) {
            try {
                routeLookupOutputView.printMenu();
            } catch (IllegalArgumentException illegalArgumentException) {
                commonOutputView.printExceptionMessage(illegalArgumentException);
            }
        }
    }
}
