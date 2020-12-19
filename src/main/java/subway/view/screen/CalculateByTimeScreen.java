package subway.view.screen;

import subway.domain.calculator.Calculator;

import java.util.Scanner;

public class CalculateByTimeScreen extends CalculateShortestPathScreen {

    public static void interact(Scanner scanner) {
        String source = inputSource(scanner);
        String dest = inputDest(scanner);
        Calculator.getShortestPathByTime(source, dest);
    }
}
