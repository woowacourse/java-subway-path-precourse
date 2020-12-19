package subway.controller;

import subway.domain.FindPathType;
import subway.domain.SectionRepository;
import subway.domain.ShortestPathFinder;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayException;
import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SubwayController {
    private static ShortestPathFinder shortestPathFinder;

    public static void run(InputView inputView) {
        shortestPathFinder = new ShortestPathFinder(StationRepository.stations(), SectionRepository.allSections());
        while (true) {
            try {
                OutputView.showMainMenu();
                MainMenu menu = MainMenu.findByCommand(inputView.nextLine());
                if (menu == MainMenu.SHOW_PATH) {
                    showShortestPathMenu(inputView);
                }
                if (menu == MainMenu.QUIT) {
                    break;
                }
            } catch (SubwayException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void showShortestPathMenu(InputView inputView) {
        OutputView.showShortestPathMenu();
        selectPathTypeAndCalculate(inputView);
    }

    private static void selectPathTypeAndCalculate(InputView inputView) {
        FindPathType findPathType = FindPathType.findByCommand(inputView.nextLine());

        OutputView.showRequestStartStationInput();
        Station from = StationRepository.findByName(inputView.nextLine());
        OutputView.showRequestEndStationInput();
        Station to = StationRepository.findByName(inputView.nextLine());

        shortestPathFinder.setType(findPathType);
        List<Station> stationsOnPath = shortestPathFinder.getStationsOnPath(from, to);
        printResult(stationsOnPath);
    }

    private static void printResult(List<Station> stations) {
        OutputView.showShortestPathResult(stations);
    }
}
