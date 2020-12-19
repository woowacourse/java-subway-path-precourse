package subway.domain;

import subway.menu.PathMenu;

import static subway.menu.PathMenu.BACK;
import static subway.menu.PathMenu.findPathMenuByOption;
import static subway.view.InputView.inputPathMenuOption;
import static subway.view.OutputView.printPathMenu;

public class PathSelectMapper {
    public static void run() {
        mapperStart();
    }

    private static void mapperStart() {
        try {
            printPathMenu();
            PathMenu selectedPathMenu = findPathMenuByOption(inputPathMenuOption());
            if (selectedPathMenu == BACK) {
                return;
            }
            selectedPathMenu.request();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }
    }
}
