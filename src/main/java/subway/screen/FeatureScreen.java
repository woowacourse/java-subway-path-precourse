package subway.screen;

import java.util.Scanner;

public class FeatureScreen implements ScreenModel {

    private final Scanner scanner;
    private final String input;

    public FeatureScreen(Scanner scanner, String input) {
        this.scanner = scanner;
        this.input = input;
    }

    @Override
    public String showScreen() {
        System.out.println("최단거리나 최소시간 실행");
        return "-1";
    }

}
