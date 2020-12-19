package subway.view;

import subway.controller.SubwayMessage;

import java.util.Scanner;

public class SubwayView {
    private Scanner scanner;

    public SubwayView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String userInput() {
        String userInput = scanner.nextLine();
        newLine();
        return userInput;
    }

    public void printMessage(SubwayMessage subwayMessage) {
        System.out.print(subwayMessage.getContent());
    }

    public void newLine() {
        System.out.println();
    }
}
