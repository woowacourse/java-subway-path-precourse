package subway.controller;

import subway.view.SubwayView;

import java.util.Objects;
import java.util.Scanner;

public class SubwayController {
    private SubwayView subwayView;

    public SubwayController(Scanner scanner) {
        subwayView = new SubwayView(scanner);
    }

    private String validateMainScreenFunction(String userInput) {
        while (!UserInputValidator.isValidMainScreenFunction(userInput)) {
            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
        }
        return userInput;
    }

    public void callMainScreenFunctionBy(String userInput) {
        if (Objects.equals(MainScreenFunction.PATH_SEARCH.getCode(), userInput)) {
            pathSearchScreen();
            return;
        }
        if (Objects.equals(MainScreenFunction.QUIT.getCode(), userInput)) {
            return;
        }
    }

    public void run() {
        subwayView.printMessage(SubwayMessage.MAIN_SCREEN);
        subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
        String userInput = validateMainScreenFunction(subwayView.userInput());
        callMainScreenFunctionBy(userInput);
    }

    private String validatePathSearchScreenFunction(String userInput) {
        while (!UserInputValidator.isValidPathSearchScreenFunction(userInput)) {
            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
        }
        return userInput;
    }

    public void pathSearchScreen() {
        subwayView.printMessage(SubwayMessage.PATH_SEARCH_SCREEN);
        subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
        String userInput = validatePathSearchScreenFunction(subwayView.userInput());
    }
}
