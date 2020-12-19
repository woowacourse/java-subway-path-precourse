package subway;

import subway.controller.ScreenController;
import subway.view.resource.Screen;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InitialSetter.setupInitialInfo();
        ScreenController.run(Screen.MAIN, scanner);
    }
}
