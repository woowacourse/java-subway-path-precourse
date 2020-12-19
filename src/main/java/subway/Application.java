package subway;

import subway.controller.ProgramController;
import subway.view.resource.Screen;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InitialSetter.setupInitialInfo();
        ProgramController.run(Screen.MAIN, scanner);
    }
}
