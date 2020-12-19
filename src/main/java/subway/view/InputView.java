package subway.view;

import subway.domain.StationRepository;

import java.util.Scanner;

public class InputView {
    private static final int ERROR = -1;
    private static final String ERROR_MESSAGE = "ERROR";
    private static final String QUIT = "Q";
    private static final String BACK = "B";
    private static final int QUIT_NUMBER = 0;

    private static final String WRITE_NUMBER = "[ERROR] 화면에 나온 입력값을 입력하세요.\n";
    private static final String NOT_EXIST_STATION = "[ERROR] 존재하지 않는 역입니다.\n";
    private static final String SAME_STATIONS = "[ERROR] 출발역과 도착역이 같을 수 없습니다.\n";

    private static final String INPUT_OPERATION_NUMBER = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_START_STATION = "## 출발 역을 입력하세요.";
    private static final String INPUT_END_STATION = "## 도착역을 입력하세요.";


    public static void print(String string) {
        System.out.println(string);
    }

    public static int inputOperationNumber(Scanner scanner, int start, int end) {
        print(INPUT_OPERATION_NUMBER);
        String tempNumber = scanner.next();
        if (tempNumber.equals(QUIT) || tempNumber.equals(BACK)) {
            return QUIT_NUMBER;
        }
        if (!tempNumber.chars().allMatch(Character::isDigit)) {
            print(WRITE_NUMBER);
            return ERROR;
        }
        int operationNumber = Integer.parseInt(tempNumber);
        if (operationNumber < start || operationNumber > end) {
            print(WRITE_NUMBER);
            return ERROR;
        }
        return operationNumber;
    }

    public static String writeStartStation(Scanner scanner) {
        print(INPUT_START_STATION);
        String stationName = scanner.next();
        if (!StationRepository.isExistStation(stationName)) {
            print(NOT_EXIST_STATION);
            return ERROR_MESSAGE;
        }
        return stationName;
    }

    public static String writeEndStation(Scanner scanner, String startStation) {
        print(INPUT_END_STATION);
        String stationName = scanner.next();
        if (startStation.equals(stationName)) {
            print(SAME_STATIONS);
            return ERROR_MESSAGE;
        }
        if (!StationRepository.isExistStation(stationName)) {
            print(NOT_EXIST_STATION);
            return ERROR_MESSAGE;
        }
        return stationName;
    }
}
