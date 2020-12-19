package subway.view;

import subway.controller.SubwayMessage;

import java.util.Scanner;

public class SubwayView {
    private Scanner scanner;

    public SubwayView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMessage(SubwayMessage subwayMessage) {
        System.out.println(subwayMessage.getContent());
    }
}
