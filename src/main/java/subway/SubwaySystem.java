package subway;

import subway.domain.MainMenu;

import java.util.Scanner;

public class SubwaySystem {
    private void subWayInit() {

    }

    public void run(Scanner scanner) {
        while (MainMenu.isMainRunning()) {
            MainMenu.mainRun(scanner);
        }
    }
}
