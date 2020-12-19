package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.RoutePage;
import utils.InputUtils;

import java.util.Scanner;

public class RouteController {
    private static final String SHORTEST_DISTANCE = "1";
    private static final String MINIMUM_TIME = "2";
    private static final String BACK = "B";
    private static final RoutePage ROUTE_PAGE= new RoutePage();

    public void startRoutePage(Scanner scanner) {
        ROUTE_PAGE.printRoutePage();
        forkPath(InputUtils.inputString(scanner), scanner);
    }

    public void forkPath(String item, Scanner scanner){
        if(SHORTEST_DISTANCE.equals(item)){
            //startSelectRoute(scanner);
            return;
        }

        if(MINIMUM_TIME.equals(item)){
            //startSelectRoute(scanner);
            return;
        }
        if(BACK.equals(item)){
            MainController.startMainPage(scanner);
            return;
        }
        ROUTE_PAGE.printWrongItemError();
        startRoutePage(scanner);
    }
}
