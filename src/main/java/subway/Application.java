package subway;

import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        SubwayPath subwayPath = new SubwayPath(inputView);

        boolean running = true;
        while (running) {
            running = subwayPath.run();
        }
    }
}
