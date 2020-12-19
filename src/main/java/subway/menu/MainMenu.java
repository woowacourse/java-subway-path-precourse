package subway.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final String SEARCH_PATH = "1";
    private static final String QUIT = "Q";
    private static final String MAIN_MENU = "MAIN MENU";

    public static void initialize(Scanner scanner) {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(SEARCH_PATH, QUIT));
        while (true) {
            showOptions();
            String result = start(scanner, authorizedCommands);
            if (result.equals(QUIT)) {
                break;
            }
        }
    }

    private static String start(Scanner scanner, List<String> authorizedCommands) {
        try {
            String command = getCommand(scanner, authorizedCommands);
            if (command.equals(QUIT)) {
                return command;
            }
            execute(command, scanner);
        } catch (Exception exception) {
            System.out.println("[ERROR] " + exception.getMessage() + "\n");
        }
        return MAIN_MENU;
    }

    private static void execute(String command, Scanner scanner) {
        if (command.equals(SEARCH_PATH)) {
            PathMenu.initialize(scanner);
        }
    }

    private static String getCommand(Scanner scanner, List<String> authorizedCommands) throws IllegalArgumentException {
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (!authorizedCommands.contains(userInput)) {
            throw new IllegalArgumentException("없는 기능입니다.");
        }
        return userInput;
    }

    private static void showOptions() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료\n");
    }
}
