package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.Screen;

import java.util.Scanner;

public class MainController {
    private MainController(){
    }

    public static void run(Scanner scanner){
        OutputView.loadView(Screen.MAIN);
        shiftFunctionScreen(InputView.getInputFunctionCode(scanner, Screen.MAIN));
    }

    private static void shiftFunctionScreen(String functionIndex) {

    }
}
