package subway.view;

import subway.Exception.CustomException;
import subway.controller.Validate;

import java.util.Scanner;

public class InputView {

    public static final String NEW_LINE = "\n";
    public static final String MSG_MENU_SELECT = "## 원하는 기능을 선택하세요.";
    public static final String PREFIX_START_STATION = "start";
    public static final String MESSAGE_START_STATION = "## 출발역을 입력하세요.";
    public static final String PREFIX_END_STATION = "end";
    public static final String MESSAGE_END_STATION = "## 도착역을 입력하세요.";

    public static String askMenu(Scanner scanner, String regex) throws CustomException{
        System.out.println(NEW_LINE + MSG_MENU_SELECT);
        String userInput = scanner.nextLine().trim();
        Validate.matchWithRegex(regex, userInput);
        return userInput;
    }

    public static String askStation(Scanner scanner, String stationPrefix) throws CustomException {
        if (stationPrefix.equals(PREFIX_START_STATION)) {
            System.out.println(NEW_LINE + MESSAGE_START_STATION);
        } else if (stationPrefix.equals(PREFIX_END_STATION)) {
            System.out.println(NEW_LINE + MESSAGE_END_STATION);
        }
        String userInput = scanner.nextLine().trim();
        Validate.existStation(userInput);
        return userInput;
    }


}