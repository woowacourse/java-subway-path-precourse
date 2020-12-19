package subway.flowchart;

import subway.domain.Constant;
import subway.domain.Menu;

import java.util.Scanner;

public class FlowChart {
    public static void flowChart(Scanner scanner) {
        Menu mainPage = new Menu(Constant.MAIN_MENU_TITLE, Constant.mainMenuItemList());
        String mainInput = mainPage.load(scanner);

    }
}
