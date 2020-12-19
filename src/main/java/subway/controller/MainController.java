package subway.controller;

import subway.exception.TransitRouteException;
import subway.menu.RouteMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    public static void viewRoute(){
        try{
            OutputView.showRouteMenu();
            RouteMenu.findByCommand(InputView.getInput()).run();
        }
        catch (TransitRouteException error){
            System.out.println(error.getMessage());
            viewRoute();
        }
    }

    public static void exit(){
        System.exit(0);
    }
}
