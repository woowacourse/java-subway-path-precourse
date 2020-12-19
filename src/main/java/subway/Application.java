package subway;

import com.sun.tools.javac.Main;
import java.util.Scanner;
import subway.domain.RouteRepository;
import subway.menu.MainMenu;
import subway.service.LineService;
import subway.service.RouteService;
import subway.service.StationService;
import subway.utils.InputUtils;
import subway.utils.OutputUtils;

public class Application {
    private static final int MAIN_MENU_BOUND=1;

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
            //경로 조회
            return true;
        }
        return false;
    }
}
