package subway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final String SEARCH_PATH = "1";
    private static final String QUIT = "Q";

    public static void initialize(Scanner scanner) {
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(SEARCH_PATH, QUIT));
        while (true) {
            showOptions();
            try {
                String command = getCommand(scanner, authorizedCommands);
                if (command.equals(QUIT)) {
                    break;
                }
            } catch (Exception exception){
                System.out.println("[ERROR] " + exception.getMessage() + "\n");
            }
        }
    }

    private static String getCommand(Scanner scanner, List<String> authorizedCommands) {
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
