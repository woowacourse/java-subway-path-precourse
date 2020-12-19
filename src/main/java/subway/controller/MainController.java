package subway.controller;

import subway.view.MainPage;
import utils.InputUtils;

import java.util.Scanner;

public class MainController {
    private static final String SELECT_ROUTE = "1";
    private static final String QUIT = "Q";
    private static final MainPage MAIN_PAGE = new MainPage();
    private Scanner scanner;

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startMainPage() {
        MAIN_PAGE.printMainPage();
        forkPath(InputUtils.inputString(scanner));
    }

    public void forkPath(String item){
        if(SELECT_ROUTE.equals(item)){

            return;
        }
        if(QUIT.equals(item)){

            return;
        }
        MAIN_PAGE.printWrongItemError();
        startMainPage();
    }
}
