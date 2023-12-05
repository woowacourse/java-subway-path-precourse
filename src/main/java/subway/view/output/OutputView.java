package subway.view.output;

import static subway.constant.Function.QUIT;
import static subway.constant.Function.SEARCHING_ROUTE;
import static subway.constant.PrintOutMessage.EMPTY_LINE;
import static subway.constant.PrintOutMessage.MAIN;
import static subway.constant.PrintOutMessage.PLZ_INPUT_END_STATION;
import static subway.constant.PrintOutMessage.PLZ_INPUT_FUNCTION;
import static subway.constant.PrintOutMessage.PLZ_INPUT_PATH_STANDARD;
import static subway.constant.PrintOutMessage.PLZ_INPUT_START_STATION;
import static subway.constant.PrintOutMessage.SEARCHING_RESULT;
import static subway.constant.PrintOutMessage.getDash;
import static subway.constant.PrintOutMessage.getRoutes;
import static subway.constant.PrintOutMessage.printTotalDistance;
import static subway.constant.PrintOutMessage.printTotalTime;
import static subway.constant.SelectRoute.BACK;
import static subway.constant.SelectRoute.MINIMUM_TIME;
import static subway.constant.SelectRoute.SHORTEST_PATH;

import java.util.List;

public class OutputView {
    public void printMain() {
        System.out.println(MAIN.getMessage());
        System.out.println(SEARCHING_ROUTE.message);
        System.out.println(QUIT.message);
        System.out.print(EMPTY_LINE.message);
    }

    public void printSelectFunc() {
        System.out.println(PLZ_INPUT_FUNCTION.getMessage());
    }

    public void printSelectPath() {
        System.out.print(EMPTY_LINE.message);
        System.out.println(PLZ_INPUT_PATH_STANDARD.getMessage());
        System.out.println(SHORTEST_PATH.message);
        System.out.println(MINIMUM_TIME.message);
        System.out.println(BACK.message);
        System.out.print(EMPTY_LINE.message);
    }

    public void printStartStation() {
        System.out.println(PLZ_INPUT_START_STATION.getMessage());
    }

    public void printEndStation() {
        System.out.println(PLZ_INPUT_END_STATION.getMessage());
    }

    public void printSearchingResult(int distance, int time) {
        System.out.println(SEARCHING_RESULT.getMessage());
        System.out.println(getDash());
        System.out.println(printTotalDistance(distance));
        System.out.println(printTotalTime(time));
        System.out.println(getDash());
    }

    public void printRoutes(List<String> routes) {
        System.out.println(getRoutes(routes));
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
