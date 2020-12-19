package subway.controller;

import subway.exception.TransitRouteException;
import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class TransitRouteController {
    public static void run(){
        while(true){
            try{
                OutputView.showMainMenu();
                MainMenu.findByCommand(InputView.getInput()).run();
            }catch (TransitRouteException errorMessage){
                System.out.println(errorMessage.getMessage());
            }
        }
    }
}
