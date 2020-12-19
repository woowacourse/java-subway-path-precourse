package subway.view;

import subway.Constant;
import subway.domain.data.Station;
import subway.menu.MainMenu;
import subway.menu.PathRuleMenu;

public class OutputView {

    public static void printMainView(){
        printHeader();
        System.out.println(Constant.VIEW_MAIN_HEADER);
        for(MainMenu mainMenu : MainMenu.values()){
            System.out.printf(Constant.VIEW_MENU_FORMAT, mainMenu.getOrder(), mainMenu.getMenuMessage());
        }
    }

    public static void printPathRuleView(){
        printHeader();
        System.out.println(Constant.VIEW_PATH_RULE_HEADER);
        for(PathRuleMenu pathRuleMenu : PathRuleMenu.values()){
            System.out.printf(Constant.VIEW_MENU_FORMAT, pathRuleMenu.getOrder(), pathRuleMenu.getMenuMessage());
        }
    }

    public static void printAskingStation(Station.POINT point){
        printHeader();
        if(point.equals(Station.POINT.STARTING)) {
            System.out.println(Constant.VIEW_ASKING_STARTING_STATION);
            return;
        }
        System.out.println(Constant.VIEW_ASKING_ENDING_STATION);
    }


    public static void printError(String errorMessage){
        System.out.printf(Constant.EXCEPTION_FORMAT, errorMessage);
    }

    public static void printResult(){

    }

    private static void printHeader(){
        System.out.print(Constant.VIEW_HEADER);
    }

    public static void printAskingFunction(){
        printHeader();
        System.out.println(Constant.VIEW_ASKING_FUNCTION);
    }
}
