package subway.controller;

import subway.domain.MenuType;
import subway.service.InputService;
import subway.view.OutputView;
import subway.service.SubwayService;

import java.util.Scanner;

import static subway.domain.MenuType.MAIN_MENU_RANGE;

public class SubwayController extends InputService {
    private final SubwayService subwayService = new SubwayService();
    
    public void start(Scanner scanner) {
        String menu = "";
        try {
            while (!MenuType.MAIN_EXIT.isKeyEquals(menu)) {
                OutputView.printMainMenu();
                menu = inputSelectMenu(scanner, MAIN_MENU_RANGE);
                subwayService.selectMainMenu(scanner, menu);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start(scanner);
        }
    }
}