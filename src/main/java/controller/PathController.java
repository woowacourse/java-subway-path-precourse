package controller;

import java.util.Scanner;

public class PathController {
    public static void run(Scanner scanner) {
        System.out.println("## 경로 기준\n" +
                "1. 최단 거리\n" +
                "2. 최소 시간\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();

        boolean inputCheck = false;
        if (userInput.equals("1")) {
            inputCheck = true;
            ShortestDistanceController.run(scanner);
        }
        if (userInput.equals("2")) {
            inputCheck = true;
            MinimumTimeController.run(scanner);
        }
        if (userInput.equals("B")) {
            inputCheck = true;
            MainController.run(scanner);
        }
        if (inputCheck == false) {
            System.out.println("[ERROR] 올바른 문자를 입력해주세요.\n");
            run(scanner);
        }
    }
}
