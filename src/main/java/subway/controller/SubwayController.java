package subway.controller;

import subway.exception.SubwayException;
import subway.repository.InitialRepository;
import subway.view.OutputView;
import subway.view.main.MainMenu;
import subway.view.main.MainScreen;

import java.util.Scanner;

public class SubwayController {
    private final InitialRepository initialRepository;
    public static Scanner scanner;

    public SubwayController(Scanner scanner) {
        initialRepository = new InitialRepository();
    }

    public void run(Scanner scanner) {
        initialRepository.initialize();
        while (true) {
            Menu(scanner);
        }
    }

    private void Menu(Scanner scanner) {
        try {
            this.scanner = scanner;
            MainScreen.showMenu();
            MainMenu menu = MainScreen.selectMenu();
            menu.request(menu.getKey());
        } catch (SubwayException e) {
            OutputView.printErrorMessage(e);
        }
    }
}
