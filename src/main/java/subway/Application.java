package subway;

import subway.controller.Controller;
import subway.service.SubwayPathRecommendationService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(scanner, new SubwayPathRecommendationService());

    }
}
