package subway.userinterface;

import subway.domain.MenuRepository;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    private static final String PREFIX = "\n## ";
    private static final String RESULT_NOTIFICATION = "조회 결과";
    private static final String MAIN_MENU = "메인 화면";
    private static final String SEARCH_MENU = "경로 기준";
    private static final String START_STATION_INPUT = "출발역을 입력하세요";
    private static final String END_STATION_INPUT = "도착역을 입력하세요";
    private static final String CHOOSE_MENU = PREFIX + "원하는 기능을 선택하세요.";

    public static String newInput() {
        return scanner.nextLine();
    }

    public static void printResultNotification() {
        System.out.println(PREFIX + RESULT_NOTIFICATION);
    }

    public static void printMainMenu() {
        System.out.println(PREFIX + MAIN_MENU);
        for (int i = 0; i < MenuRepository.mainMenuButtons.size(); i++) {
            System.out.println(MenuRepository.mainMenuButtons.get(i) + ". " + MenuRepository.mainMenuNames.get(i));
        }
        System.out.println(CHOOSE_MENU);
    }

    public static void printSearchMenu() {
        System.out.println(PREFIX + SEARCH_MENU);
        for (int i = 0; i < MenuRepository.searchMenuButtons.size(); i++) {
            System.out.println(MenuRepository.searchMenuButtons.get(i) + ". " + MenuRepository.searchMenuNames.get(i));
        }
        System.out.println(CHOOSE_MENU);
    }

    public static void printStartStation() {
        System.out.println(PREFIX + START_STATION_INPUT);
    }

    public static void printEndStation() {
        System.out.println(PREFIX + END_STATION_INPUT);
    }

    public static void closeScanner() {
        scanner.close();
    }
}
