package subway;

import subway.domain.DataInitializer;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView.setScanner(scanner);

        DataInitializer.initialize();

    }
}
