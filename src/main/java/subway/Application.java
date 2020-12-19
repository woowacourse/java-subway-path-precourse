package subway;

import com.sun.tools.javac.Main;
import java.util.Scanner;
import subway.domain.RouteRepository;
import subway.menu.MainMenu;
import subway.menu.RouteInquiryMenu;
import subway.service.LineService;
import subway.service.RouteService;
import subway.service.StationService;
import subway.utils.InputUtils;
import subway.utils.OutputUtils;

public class Application {
    private static final int MAIN_MENU_BOUND=1;
    private static final int INQUIRY_MENU_BOUND=2;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initializeProgram();
        while(true){
            if(mainFunction(scanner)==false)
                break;
        }
    }

    public static void initializeProgram(){
        LineService.initialize();
        StationService.initialize();
        RouteService.initialize();
    }

    public static boolean mainFunction(Scanner scanner){
        OutputUtils.mainMenu();
        char mainMenu = InputUtils.inputFunctionSelect(scanner, MAIN_MENU_BOUND, MainMenu.QUIT.getMenu());
        if(MainMenu.QUIT.matchMenu(mainMenu)){
            return false;
        }
        if(MainMenu.ROUTE_INQUIRY.matchMenu(mainMenu)){
            routeInquiryMenu(scanner);
            return true;
        }
        return false;
    }
    
    public static void routeInquiryMenu(Scanner scanner){
        OutputUtils.routeInquiryMenu();
        char inquiryMenu = InputUtils.inputFunctionSelect(scanner, INQUIRY_MENU_BOUND,
            RouteInquiryMenu.BACK.getMenu());
        if(RouteInquiryMenu.BACK.matchMenu(inquiryMenu)){
            return;
        }
        if(RouteInquiryMenu.SHORTEST_DISTANCE.matchMenu(inquiryMenu)){
            //최단 경로 조회
            return;
        }
        if(RouteInquiryMenu.MINIMUM_TIME.matchMenu(inquiryMenu)){
            //최소 시간 조회
            return;
        }
    }
}
