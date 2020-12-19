package subway.controller;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Consumer;
import subway.Error;
import subway.Scene;
import subway.menu.MainMenu;
import subway.view.MainView;

public class MainViewController extends ViewController{ 
    
    public MainViewController(Scanner scanner, PrintStream printStream) {
        view = new MainView(scanner, printStream);
    }

    @Override
    public Consumer<Scene> selectMenu() {
        String input = view.requestMenu();
        Consumer<Scene> result = MainMenu.getAction(input);
        if (result == null) {
            view.printError(Error.INVALID_MENU);
        }
        return result;
    }
    
    public static void goSectionView(Scene scene) {
        scene.goView(new SectionViewController(scene.getScanner(), scene.getPrinstream()));
    }
    
    public static void exit(Scene scene) {
        scene.exit();
    }
}
