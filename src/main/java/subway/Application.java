package subway;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.mainview.MainView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView.scanner = scanner;
        MainView mainView = new MainView();
        mainView.setVisible();
    }
}
