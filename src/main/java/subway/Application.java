package subway;

import java.util.Scanner;
import subway.controller.exception.RetryHandler;
import subway.domain.PathResult;
import subway.domain.Station;
import subway.domain.SubwayService;
import subway.domain.repository.RepositoryConfig;
import subway.domain.repository.StationRepository;
import subway.view.View;

public class Application {
    private static final View view = new View();
    private static final RetryHandler handler = new RetryHandler();
    private static SubwayService subwayService;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        RepositoryConfig.initRepository();
        subwayService = new SubwayService();

        handler.runOrRetry(() -> run(scanner));
    }

    public static void run(Scanner scanner){
        while(true) {
            view.printMenuView();
            String input = scanner.nextLine();
            if (input.equals("Q")) {
                return;
            }
            if (input.equals("1")) {
                handler.runOrRetry(() -> findPath(scanner));
                continue;
            }
            throw new IllegalArgumentException("잘못된 메뉴 입력입니다.");
        }
    }

    private static void findPath(Scanner scanner) {
        view.printPathMenu();
        String input = scanner.nextLine();
        if (input.equals("B")) {
            return;
        }
        if (input.equals("1") || input.equals("2")) {
            _findPath(scanner, input);
            return;
        }

        //todo
        throw new IllegalArgumentException("잘못된 메뉴 입력입니다.");
    }

    private static void _findPath(Scanner scanner, String input) {
        view.guideStartStation();
        Station start = getStation(scanner);
        view.guideEndStation();
        Station end = getStation(scanner);
        PathResult result = null;
        if(input.equals("1")){
            result = subwayService.findShortestPath(start, end);
        }
        if (input.equals("2")) {
            result = subwayService.findFastestPath(start, end);
        }
        view.printPathResult(result);
    }

    private static Station getStation(Scanner scanner) {
        String stationName = scanner.nextLine();
        return StationRepository.getStationByName(stationName);
    }


}
