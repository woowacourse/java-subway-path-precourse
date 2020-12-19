package subway.controller;

import java.io.PrintStream;
import java.util.Scanner;
import subway.Scene;

public class MainController {
    Scene scene;

    public MainController(Scanner scanner, PrintStream printStream) {
        scene = new Scene(scanner, printStream);
    }

    public void run() {
        while (!scene.isExit()) {
            scene.runCurrentView();
        }
    }
}
