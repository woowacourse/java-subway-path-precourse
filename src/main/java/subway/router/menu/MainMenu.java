package subway.router.menu;

import subway.router.PathRouter;
import subway.view.OutputView;
import java.util.Arrays;

public enum MainMenu {
    STATION_MENU("1", "1. 경로 조회", PathRouter::run),
    EXIT("Q", "Q. 종료", MainMenu::exit);

    private static final String name = "## 메인 화면";
    private static boolean restart = true;
    private String number;
    private String menu;
    private Runnable nextAction;

    MainMenu(String number, String menu, Runnable nextAction) {
        this.number = number;
        this.menu = menu;
        this.nextAction = nextAction;
    }

    public static void printMenu() {
        OutputView.print(name);
        Arrays.stream(MainMenu.values())
                .forEach(mainMenu -> OutputView.print(mainMenu.getMenu()));
    }

    private static void exit() {
        restart = false;
    }

    public String getMenu() {
        return menu;
    }
}
