package subway.userinterface;

import subway.domain.MenuRepository;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);
    private static final String PREFIX = "\n## ";

    public static String newInput() {
        return scanner.nextLine();
    }

    public static void printMainMenu() {
        System.out.println(PREFIX+"메인 화면");
        for (int i=0; i< MenuRepository.mainMenuButtons.size(); i++) {
            System.out.println(MenuRepository.mainMenuButtons.get(i) +". "+MenuRepository.mainMenuNames.get(i));
        }
    }

    public static void printSearchMenu() {
        System.out.println(PREFIX+"경로 기준");
        for (int i=0; i< MenuRepository.mainMenuButtons.size(); i++) {
            System.out.println(MenuRepository.searchMenuButtons.get(i) +". "+MenuRepository.searchMenuNames.get(i));
        }
    }
}
