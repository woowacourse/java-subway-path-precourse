package subway.controller;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Consumer;
import subway.Scene;
import subway.view.View;

public abstract class ViewController {
    View view;
    
    public ViewController() {
    }
    
    abstract public Consumer<Scene> selectMenu();
    
    public void run (Scene scene) {
        Consumer<Scene> action = selectMenu();
        if (action != null) {
            action.accept(scene);
        }
    }
}
