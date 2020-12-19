package subway.controller;

import subway.view.SubwayView;

import javax.swing.plaf.SeparatorUI;
import java.util.Scanner;

public class SubwayController {
    private SubwayView subwayView;

    public SubwayController(Scanner scanner) {
        subwayView = new SubwayView(scanner);
    }

    public String validateMainScreenFunction(String userInput) {
        while (!UserInputValidator.isValidMainScreenFunction(userInput)) {
            subwayView.printMessage(SubwayMessage.ERROR_SELECT_FUNCTION);
            subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
            userInput = validateMainScreenFunction(subwayView.userInput());
        }
        return userInput;
    }

    public void run() {
        subwayView.printMessage(SubwayMessage.MAIN_SCREEN);
        subwayView.printMessage(SubwayMessage.SELECT_FUNCTION);
        String userInput = validateMainScreenFunction(subwayView.userInput());
    }
}
