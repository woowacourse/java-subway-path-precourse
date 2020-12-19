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

public class SubwayController {
    private static ShortestPathFinder shortestPathFinder;
    public static void run(InputView inputView){
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
                OutputView.println(e.getMessage());
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
        Station to = StationRepository.findByName(inputView.nextLine());
        calculateAndPrint();
    }

    private static void calculateAndPrint() {
    }
}
