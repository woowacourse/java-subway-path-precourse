package subway;

import com.sun.tools.javac.Main;
import java.util.Scanner;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.MainMenu;
import subway.menu.RouteInquiryMenu;
import subway.service.LineService;
import subway.service.RouteService;
import subway.service.ShortestPathRouteService;
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
        StationService.initialize();
        LineService.initialize();
        RouteService.initialize();
    }

    public static boolean mainFunction(Scanner scanner){
        OutputUtils.mainMenu();
        char mainMenu = InputUtils.inputFunctionSelect(scanner, MAIN_MENU_BOUND, MainMenu.QUIT.getMenu());
        if(MainMenu.QUIT.matchMenu(mainMenu)){
            return false;
        }
        if(MainMenu.ROUTE_INQUIRY.matchMenu(mainMenu)){
            while(routeInquiryMenu(scanner));
            return true;
        }
        return false;
    }
    
    public static boolean routeInquiryMenu(Scanner scanner){
        OutputUtils.routeInquiryMenu();
        char inquiryMenu = InputUtils.inputFunctionSelect(scanner, INQUIRY_MENU_BOUND,
            RouteInquiryMenu.BACK.getMenu());
        if(RouteInquiryMenu.BACK.matchMenu(inquiryMenu)){
            return false;
        }
        if(RouteInquiryMenu.SHORTEST_DISTANCE.matchMenu(inquiryMenu)){
            return shortestPathMenu(scanner);
        }
        if(RouteInquiryMenu.MINIMUM_TIME.matchMenu(inquiryMenu)){
            //최소 시간 조회
            return false;
        }
        return false;
    }

    public static boolean shortestPathMenu(Scanner scanner){
        OutputUtils.inputStartStationGuide();
        String startStation = InputUtils.inputStationName(scanner);
        OutputUtils.inputEndStationGuide();
        String endStation = InputUtils.inputStationName(scanner);

        if(startStation.equals(endStation)) {
            OutputUtils.sameStationNameError();
            return true;
        }

        ShortestPathRouteService shortestPathRouteService = new ShortestPathRouteService(startStation, endStation);
        return false;
    }
}
