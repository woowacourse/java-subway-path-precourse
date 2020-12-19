package subway.view.output;

import java.util.List;

public class MainOutputView extends OutputView {
    private static String MAIN_VIEW = "메인 화면\n";

    public void printMainMenu(List<String> list) {
        printMenu(MAIN_VIEW, list);
    }

    public void selectMenu() {
        menuSymbol();
        stringBuilder.append(SELECT_MENU);
        print();
    }
}
