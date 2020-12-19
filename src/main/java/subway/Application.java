package subway;

import subway.view.UserInterface;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        UserInterface userInterface = new UserInterface(scanner);

        userInterface.runApplication();
    }
}