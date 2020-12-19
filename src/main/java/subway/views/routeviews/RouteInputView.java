package subway.views.routeviews;

import subway.views.OutputView;

import java.util.Scanner;

public class RouteInputView {
    public static String inputRouteOption(Scanner scanner) {
        OutputView.printSelectOptionMessage();
        return scanner.nextLine();
    }
}
