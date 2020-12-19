package subway;

import subway.controller.SubwayPathApplication;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
    
        SubwayPathApplication.run(scanner);
    }
}
