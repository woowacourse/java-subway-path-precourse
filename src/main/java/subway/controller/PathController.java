package subway.controller;

import subway.controller.enums.PathMenu;
import subway.view.OutputView;
import subway.view.inputview.PathView;

import java.util.Scanner;

public class PathController extends Controller {
    private static PathController pathController;
    private PathView pathView;
    private PathMenu pathMenu;

    private PathController(Scanner scanner) {
        super(scanner);
        pathView = PathView.getInstance(scanner);
    }

    public static PathController getInstance(Scanner scanner) {
        if (pathController == null) {
            pathController = new PathController(scanner);
        }

        return pathController;
    }

    @Override
    public void run() {
        while (true) {
            pathView.showOption();
            pathMenu = PathMenu.findMainMenu(selectMenu());

            if (pathMenu.run()) {
                return;
            }
        }
    }

    @Override
    public String selectMenu() {
        try {
            String selectedMenu = pathView.inputCommand();
            return selectedMenu;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return selectMenu();
        }
    }
}
