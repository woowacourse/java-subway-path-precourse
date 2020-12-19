package subway.controller;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.BiConsumer;
import subway.Error;
import subway.Scene;
import subway.menu.MainMenu;
import subway.view.MainView;
import subway.view.View;

public class MainViewController extends ViewController {

    public MainViewController(Scanner scanner, PrintStream printStream) {
        view = new MainView(scanner, printStream);
    }

    @Override
    public BiConsumer<Scene, View> selectMenu() {
        String input = view.requestMenu();
        BiConsumer<Scene, View> result = MainMenu.getAction(input);
        if (result == null) {
            view.printError(Error.INVALID_MENU);
        }
        return result;
    }

    public static void goSectionView(Scene scene, View view) {
        scene.goView(new SectionViewController(scene.getScanner(), scene.getPrinstream()));
    }

    public static void exit(Scene scene, View view) {
        scene.exit();
    }
}
