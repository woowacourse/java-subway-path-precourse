package subway;

import java.util.Scanner;
import subway.controller.SubwayPathFindController;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        SubwayPathFindController subwayPathFindController = new SubwayPathFindController();
        subwayPathFindController.run();
    }
}
