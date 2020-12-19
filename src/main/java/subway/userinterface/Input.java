package subway.userinterface;

import subway.domain.MenuRepository;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PREFIX = "\n## ";
    private static final String CHOOSE_MENU = PREFIX + "원하는 기능을 선택하세요.";

    public static String newInput() {
        return scanner.nextLine();
    }

    public static void printResultNotification() {
        System.out.println(PREFIX+"조회 결과");
    }

    public static void printMainMenu() {
        System.out.println(PREFIX + "메인 화면");
        for (int i = 0; i < MenuRepository.mainMenuButtons.size(); i++) {
            System.out.println(MenuRepository.mainMenuButtons.get(i) + ". " + MenuRepository.mainMenuNames.get(i));
        }
        System.out.println(CHOOSE_MENU);
    }

    public static void printSearchMenu() {
        System.out.println(PREFIX + "경로 기준");
        for (int i = 0; i < MenuRepository.searchMenuButtons.size(); i++) {
            System.out.println(MenuRepository.searchMenuButtons.get(i) + ". " + MenuRepository.searchMenuNames.get(i));
        }
        System.out.println(CHOOSE_MENU);
    }

    public static void printStartStation() {
        System.out.println(PREFIX + "출발역을 입력하세요");
    }

    public static void printEndStation() {
        System.out.println(PREFIX + "도착역을 입력하세요");
    }
}
