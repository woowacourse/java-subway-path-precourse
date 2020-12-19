package subway;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;
import subway.controller.MainViewController;
import subway.controller.ViewController;

public class Scene {
    private final Scanner scanner;
    private final PrintStream printStream;
    private final Stack<ViewController> controllers = new Stack<ViewController>();
    
    public Scene(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
        controllers.add(new MainViewController(scanner, printStream));
    }
    
    public void runCurrentView() {
        ViewController viewController = controllers.peek();
        viewController.run(this);
    }
    
    public void goView(ViewController controller) {
        controllers.push(controller);
    }
    
    public void back() {
        controllers.pop();
    }
    
    public void exit() {
        controllers.clear();
    }
    
    public boolean isExit() {
        return controllers.empty();
    }
    
    public Scanner getScanner() {
        return scanner;
    }
    
    public PrintStream getPrinstream() {
        return printStream;
    }
}
