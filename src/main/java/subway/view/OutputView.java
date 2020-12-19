package subway.view;

import java.util.List;

public class OutputView {
    OutputMessages outputMessages;

    public OutputView() {
        this.outputMessages = new OutputMessages();
    }

    public void mainView() {
        System.out.println(outputMessages.MAIN_VIEW);
        String[] messages = outputMessages.MAIN_OPTIONS;
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void getUserOption() {
        System.out.println(outputMessages.SELECT_OPTION);
    }

    public void mapView() {
        System.out.println(outputMessages.MAP_VIEW);
        String[] messages = outputMessages.MAP_OPTIONS;
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void getUserStart() {
        System.out.println(outputMessages.INPUT_START);
    }

    public void getUserArrive() {
        System.out.println(outputMessages.INPUT_ARRIVE);
    }

    public void printResult() {
        System.out.println(outputMessages.RESULT);
    }

    public void printDivide() {
        System.out.println(outputMessages.INFO + outputMessages.DIVIDE);
    }

    public void printShortestPath(List<String> shortestPath) {
        for (String path : shortestPath) {
            System.out.println(outputMessages.INFO + path);
        }
    }

    public void printTotalDistance(int distance) {
        System.out.println(outputMessages.INFO + outputMessages.RESULT_DISTANCE + distance + outputMessages.RESULT_KM);
    }

    public void printTotalTime(int time) {
        System.out.println(outputMessages.INFO + outputMessages.RESULT_TIME + time + outputMessages.RESULT_MIN);
    }

    public void printError() {
        System.out.println(outputMessages.UNLINKED_STATION_ERROR);
    }
}
