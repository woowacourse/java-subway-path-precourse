package subway.domain;

import java.util.Scanner;

public class ViewPath {

    private static final String PATH_CRITERIA = "## 경로 기준";
    private static final String MIN_DISTANCE = "1. 최단 거리";
    private static final String MIN_TIME = "2. 최소 시간";
    private static final String BACK = "B. 돌아가기";
    private static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요";
    private static final String START_STATION = "## 출발역을 입력하세요";
    private static final String END_STATION = "## 도착역을 입력하세요";
    private static final String FUNCTION_MIN_DISTANCE = "1";
    private static final String FUNCTION_MIN_TIME = "2";
    private static final String FUNCTION_BACK = "B";
    private boolean goBack = false;

    Input input = new Input();

    public void printFirstPathScreen() {
        System.out.println(PATH_CRITERIA);
        System.out.println(MIN_DISTANCE);
        System.out.println(MIN_TIME);
        System.out.println(BACK);
        System.out.println();
    }

    public String printFunctionScreen(Scanner scanner) {
        System.out.println(SELECT_FUNCTION);
        String function = input.findPath(scanner);
        System.out.println();
        return function;
    }

    public String printInputStartStation(Scanner scanner, String function) {
        if (function.equals(FUNCTION_MIN_DISTANCE) || function.equals(FUNCTION_MIN_TIME)) {
            System.out.println(START_STATION);
            String startStation = input.findStation(scanner);
            System.out.println();
            return startStation;
        }
        throw new IllegalArgumentException();
    }

    public String printInputEndStation(Scanner scanner, String function) {
        if (function.equals(FUNCTION_MIN_DISTANCE) || function.equals(FUNCTION_MIN_TIME)) {
            System.out.println(END_STATION);
            String endStation = input.findStation(scanner);
            System.out.println();
            return endStation;
        }
        throw new IllegalArgumentException();
    }

    private void checkGoBack(String function) {
        if (function.equals(FUNCTION_BACK)) {
            this.goBack = true;
        }
    }

    public void printPathProgram(Scanner scanner) {
        this.goBack = false;
        while (!goBack) {
            try {
                printFirstPathScreen();
                String function = printFunctionScreen(scanner);
                printInputStartStation(scanner, function);
                printInputEndStation(scanner, function);
                checkGoBack(function);
            } catch (IllegalArgumentException illegalArgumentException) {

            }
        }
    }


}
