package subway.view;

import subway.Constant;
import subway.menu.MainMenu;

public class OutputView {

    public static void printMainView(){
        printHeader();
        System.out.println(Constant.VIEW_MAIN_HEADER);
        for(MainMenu mainMenu : MainMenu.values()){
            System.out.printf(Constant.VIEW_MENU_FORMAT, mainMenu.getOrder(), mainMenu.getMenuMessage());
        }
        printAskingFunction();
    }

    public static void printPathRuleView(){

    }

    public static void printAskingStartingStation(){

    }

    public static void printAskingEndingStation(){

    }

    public static void printResult(){

    }

    private static void printHeader(){
        System.out.print(Constant.VIEW_HEADER);
    }

    private static void printAskingFunction(){
        System.out.println();
        printHeader();
        System.out.println(Constant.VIEW_ASKING_FUNCTION);
    }
}
