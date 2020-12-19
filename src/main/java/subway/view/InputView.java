package subway.view;

import subway.Exception.CustomException;
import subway.controller.Validate;

import java.util.Scanner;

public class InputView {

    public static String askMenu(Scanner scanner, String regex) throws CustomException{
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine().trim();
        Validate.matchWithRegex(regex, userInput);
        return userInput;
    }

    public static String askStation(Scanner scanner, String stationPrefix) throws CustomException {
        if (stationPrefix.equals("start")) {
            System.out.println("\n## 출발역을 입력하세요.");
        } else if (stationPrefix.equals("end")) {
            System.out.println("\n## 도착역을 입력하세요.");
        }
        String userInput = scanner.nextLine().trim();
        Validate.existStation(userInput);
        return userInput;
    }


}