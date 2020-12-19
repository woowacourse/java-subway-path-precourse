package subway.view;

import java.util.Scanner;

import subway.domain.NotExistPathException;
import subway.domain.NotExistStationException;
import subway.domain.SameStationNameException;
import subway.domain.StationRepository;
import subway.menu.MainMenu;
import subway.menu.NotAccptedMenuInputException;
import subway.menu.SubMenu;

public class InputView {
    private static final String INPUT_FUNCTION_MESSAGE = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_DEPARTURE_STATION_MESSAGE = "\n## 출발역을 입력하세요.";
    private static final String INPUT_ARRIVAL_STATION_MESSAGE = "\n## 도착역을 입력하세요.";

    private static final boolean IS_MAIN_MENU = true;
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputMainMenu() {
        String menuNumber = "";
        try {
            menuNumber = scanWithInputMessage(IS_MAIN_MENU);
        } catch (NotAccptedMenuInputException e) {
            OutputView.printErrorMessage(e);
            inputMainMenu();
        }
        return menuNumber;
    }

    public String inputSubMenu() {
        String menuNumber = "";
        try {
            menuNumber = scanWithInputMessage(!IS_MAIN_MENU);
        } catch (NotAccptedMenuInputException e) {
            OutputView.printErrorMessage(e);
            inputMainMenu();
        }
        return menuNumber;
    }

    public String inputDepartureStation() {
        String name = "";
        try {
            name = scanWithInputStationMessage();
        } catch (NotExistStationException e) {
            OutputView.printErrorMessage(e);
        }
        return name;
    }

    public String inputArrivalStation(String departureStation) {
        String name = "";
        try {
            name = scanWithInputStationMessage(departureStation);
        } catch (NotExistStationException e) {
            OutputView.printErrorMessage(e);
        } catch (SameStationNameException e) {
            OutputView.printErrorMessage(e);
        }
        return name;
    }

    private String scanWithInputMessage(boolean isMainMenu) {
        System.out.println(INPUT_FUNCTION_MESSAGE);

        if (isMainMenu) {
            return isAccptedMainMenuInput(scanner.nextLine());
        }
        return isAccptedSubMenuInput(scanner.nextLine());
    }

    private String scanWithInputStationMessage() {
        System.out.println(INPUT_DEPARTURE_STATION_MESSAGE);
        return isAccptedDepartureInput(scanner.nextLine());
    }

    private String scanWithInputStationMessage(String departureStation) {
        System.out.println(INPUT_ARRIVAL_STATION_MESSAGE);
        return isAccptedArrivalInput(scanner.nextLine(), departureStation);
    }

    private String isAccptedMainMenuInput(String menu) {
        if (menu.equals(MainMenu.PATH_VIEW_SEL) || menu.equals(MainMenu.QUIT_MENU_SEL)) {
            return menu;
        }
        throw new NotAccptedMenuInputException();
    }

    private String isAccptedSubMenuInput(String menu) {
        if (menu.equals(SubMenu.MINIMUM_DISTANCE) || menu.equals(SubMenu.MINIMUM_TIME)
                || menu.equals(SubMenu.BACK_MENU_SEL)) {
            return menu;
        }
        throw new NotAccptedMenuInputException();
    }

    private String isAccptedDepartureInput(String name) {
        if (StationRepository.stations().stream().noneMatch(station -> station.getName().equals(name))) {
            throw new NotExistStationException();
        }
        return name;
    }

    private String isAccptedArrivalInput(String name, String departureStation) {
        if (StationRepository.stations().stream().noneMatch(station -> station.getName().equals(name))) {
            throw new NotExistStationException();
        }

        if (name.equals(departureStation)) {
            throw new SameStationNameException();
        }
        return name;
    }
}
