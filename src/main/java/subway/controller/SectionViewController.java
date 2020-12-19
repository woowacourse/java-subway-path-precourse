package subway.controller;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Consumer;
import subway.Error;
import subway.Scene;
import subway.menu.SectionMenu;
import subway.view.SectionView;

public class SectionViewController extends ViewController{

    public SectionViewController(Scanner scanner, PrintStream printStream) {
        view = new SectionView(scanner, printStream);
    }

    @Override
    public Consumer<Scene> selectMenu() {
        String input = view.requestMenu();
        Consumer<Scene> result = SectionMenu.getAction(input);
        if (result == null) {
            view.printError(Error.INVALID_MENU);
        }
        return result;
    }
    
    public static void findMinDistance(Scene scene) {
        scene.back();
    }
    
    public static void findMinTime(Scene scene) {
        scene.back();
    }
    
    public static void back(Scene scene) {
        scene.back();
    }
}
