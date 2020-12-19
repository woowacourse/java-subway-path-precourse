package subway.controller;

import subway.exception.SubwayException;
import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private static InputView inputView;

    public static void run(InputView inputView){
        SubwayController.inputView = inputView;
        while (true) {
            try {
                OutputView.showMainMenu();
                MainMenu menu = MainMenu.findByCommand(inputView.nextLine());
                if (menu == MainMenu.SHOW_PATH) {
                    showPath();
                }
                if (menu == MainMenu.QUIT) {
                    break;
                }
            } catch (SubwayException e) {
                OutputView.println(e.getMessage());
            }
        }
    }

    private static void showPath() {

    }
}
