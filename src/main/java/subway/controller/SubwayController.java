package subway.controller;

import subway.domain.MenuType;
import subway.service.InputService;
import subway.service.OutputView;
import subway.service.SubwayService;

import java.util.Scanner;

public class SubwayController {
    private final InputService inputService = new InputService();
    private final SubwayService subwayService = new SubwayService();

    public void start(Scanner scanner) {
        String menu = "";
        try {
            while (!MenuType.MAIN_EXIT.isKeyEquals(menu)) {
                OutputView.printMainMenu();
                menu = inputService.inputSelectMenu(scanner);
                subwayService.selectMainMenu(scanner, menu);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start(scanner);
        }
    }
}