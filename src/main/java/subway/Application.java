package subway;

import com.sun.tools.javac.Main;
import subway.util.MapInitializer;
import subway.view.MainView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        MapInitializer mapInitializer = new MapInitializer();
        MainView.printMainView(scanner);
    }
}
