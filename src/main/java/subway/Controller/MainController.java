package subway.Controller;


import subway.View.InputView;
import subway.View.OutputView;

import java.util.Scanner;

public class MainController {
    private static final String MAIN_CONTROLLER_MENU_QUIT="Q";
    private static final String MAIN_CONTROLLER_PATH_SEARCH="1";
    Scanner scanner;
    OutputView outputView=new OutputView();
    InputView inputView=new InputView();
    PathController pathController=new PathController();

    public MainController(Scanner scanner){
        this.scanner=scanner;
        startMainMenu(scanner);
    }
    public void startMainMenu(Scanner scanner) {
        while(true) {
                outputView.setMainMenuMainDisplay();
                String tmpSaveMenuChoice = inputView.getChooseFunction(scanner);
                if (tmpSaveMenuChoice.equals(MAIN_CONTROLLER_MENU_QUIT)) {
                    break;
                }
                if (tmpSaveMenuChoice.equals(MAIN_CONTROLLER_PATH_SEARCH)) {
                    pathController.startPathMenu(scanner);
                    continue;
                }
        }
    }
}
