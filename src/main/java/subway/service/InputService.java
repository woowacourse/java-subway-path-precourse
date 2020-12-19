package subway.service;

import subway.view.InputView;

import java.util.Scanner;

public class InputService extends InputView {

    public String inputSelectMenu(Scanner scanner) {
        inputSelectMenuMessage();
        String menu = scanner.nextLine();
        return menu;
    }
}