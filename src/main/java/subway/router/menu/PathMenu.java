package subway.router.menu;

import subway.controller.PathController;
import subway.exception.MenuNotSupportedException;
import subway.view.OutputView;
import java.util.Arrays;
import java.util.function.Consumer;

public enum PathMenu {
    DISTANCE("1", "1. 최단 거리", PathController::calculateShortDistance),
    TIME("2", "2. 최소 시간", PathController::calculateMinimumTime),
    BACK("B", "B. 돌아가기", (LineController) -> PathMenu.goBack());

    private static final String name = "## 경로 기준";
    private static boolean restart = true;
    private String number;
    private String menu;
    private Consumer<PathController> nextAction;

    PathMenu(String number, String menu, Consumer<PathController> nextAction) {
        this.number = number;
        this.menu = menu;
        this.nextAction = nextAction;

    }

    public static void initMenuStatus() {
        restart = true;
    }

    public static void printMenu() {
        OutputView.printNewLine();
        OutputView.print(name);
        Arrays.stream(PathMenu.values())
                .forEach(pathMenu -> OutputView.print(pathMenu.getMenu()));
    }

    public static PathMenu getMainMenuType(String selectMenu) {
        return Arrays.stream(PathMenu.values())
                .filter(patMainMenu -> patMainMenu.number.equals(selectMenu))
                .findFirst()
                .orElseThrow(MenuNotSupportedException::new);
    }

    public void execute(PathController pathController) {
        nextAction.accept(pathController);
    }

    public static boolean isRestart() {
        return restart;
    }

    private static void goBack() {
        restart = false;
    }

    private String getMenu() {
        return menu;
    }
}
