package subway.controller;

import subway.view.SubwayView;

import java.util.Objects;
import java.util.Scanner;

public class SubwayController {
    private SubwayView subwayView;

    public SubwayController(Scanner scanner) {
        subwayView = new SubwayView(scanner);
    }

    public void run() {
        redirectToMainScreen();
    }

    private String validateMainScreenFunction(String userInput) {
        while (!UserInputValidator.isValidMainScreenFunction(userInput)) {
            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
        }
        return userInput;
    }

    private void callMainScreenFunctionBy(String userInput) {
        if (Objects.equals(MainScreenFunction.PATH_SEARCH.getCode(), userInput)) {
            redirectToPathSearchScreen();
            return;
        }
        if (Objects.equals(MainScreenFunction.QUIT.getCode(), userInput)) {
            return;
        }
    }

    private void redirectToMainScreen() {
        String userInput = "";
        while (!Objects.equals(MainScreenFunction.QUIT.getCode(), userInput)) {
            subwayView.printMessage(SubwayMessage.MAIN_SCREEN);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
            callMainScreenFunctionBy(userInput);
        }
    }

    private String validatePathSearchScreenFunction(String userInput) {
        while (!UserInputValidator.isValidPathSearchScreenFunction(userInput)) {
            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
        }
        return userInput;
    }

    private void callPathSearchScreenFunctionBy(String userInput) {
        if (Objects.equals(PathSearchScreenFunction.SHORTEST_PATH.getCode(), userInput)) {
            searchByShortestPath();
            return;
        }
        if (Objects.equals(PathSearchScreenFunction.MINIMUM_TIME.getCode(), userInput)) {
            searchByMinimumTime();
            return;
        }
        if (Objects.equals(PathSearchScreenFunction.BACK.getCode(), userInput)) {
            return;
        }
    }

    private void redirectToPathSearchScreen() {
        subwayView.printMessage(SubwayMessage.PATH_SEARCH_SCREEN);
        subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
        String userInput = validatePathSearchScreenFunction(subwayView.userInput());
        callPathSearchScreenFunctionBy(userInput);
    }

//    private String validateDepartureStation(String userInput) {
//        while (!UserInputValidator.isValidPathSearchScreenFunction(userInput)) {
//            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
//            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
//            userInput = validateMainScreenFunction(subwayView.userInput());
//        }
//        return userInput;
//    }
//
//    private String inputDepartureStation() {
//        subwayView.printMessage(SubwayMessage.ENTER_DEPARTURE_STATION);
//        String userInput = validateDepartureStation(subwayView.userInput());
//        return userInput;
//    }
//
//    private String validateArrivalStation(String userInput) {
//        while (!UserInputValidator.isValidPathSearchScreenFunction(userInput)) {
//            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
//            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
//            userInput = validateMainScreenFunction(subwayView.userInput());
//        }
//        return userInput;
//    }
//
//    private String inputArrivalStation() {
//        subwayView.printMessage(SubwayMessage.ENTER_ARRIVAL_STATION);
//        String userInput = validateArrivalStation(subwayView.userInput());
//        return userInput;
//    }

    private String inputDepartureStation() {
        subwayView.printMessage(SubwayMessage.ENTER_DEPARTURE_STATION);
        String userInput = subwayView.userInput();
        return userInput;
    }

    private String inputArrivalStation() {
        subwayView.printMessage(SubwayMessage.ENTER_ARRIVAL_STATION);
        String userInput = subwayView.userInput();
        return userInput;
    }

    private void searchByShortestPath() {
        String userInput = inputDepartureStation();
        userInput = inputArrivalStation();
    }

    private void searchByMinimumTime() {
        String userInput = inputDepartureStation();
        userInput = inputArrivalStation();
    }
}
