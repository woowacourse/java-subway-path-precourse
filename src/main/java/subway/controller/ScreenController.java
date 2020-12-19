package subway.controller;

import subway.view.resource.Screen;

import java.util.Scanner;

public class ScreenController {
    private ScreenController(){
    }

    public static void run(Screen screen, Scanner scanner){
        if (screen.equals(Screen.MAIN)){
            MainController.run(scanner);
        }
        if (screen.equals(Screen.PATH)){
            PathController.run(scanner);
        }
    }
}
