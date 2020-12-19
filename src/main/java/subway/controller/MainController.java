package subway.controller;

import subway.Initial;
import subway.domain.LineRepository;
import subway.view.MainPage;
import utils.InputUtils;

import java.util.Scanner;

public class MainController {
    private static final String SELECT_ROUTE = "1";
    private static final String QUIT = "Q";
    private static final MainPage MAIN_PAGE = new MainPage();
    private static final RouteController ROUTE_CONTROLLER = new RouteController();

    public static void startProgram(Scanner scanner){
        Initial.setInitial();
        startMainPage(scanner);
    }

    public static void startMainPage(Scanner scanner) {
        MAIN_PAGE.printMainPage();
        forkPath(InputUtils.inputString(scanner), scanner);
    }

    public static void forkPath(String item, Scanner scanner){
        if(SELECT_ROUTE.equals(item)){
            ROUTE_CONTROLLER.startRoutePage(scanner);
            return;
        }
        if(QUIT.equals(item)){
            return;
        }
        MAIN_PAGE.printWrongItemError();
        startMainPage(scanner);
    }
}
