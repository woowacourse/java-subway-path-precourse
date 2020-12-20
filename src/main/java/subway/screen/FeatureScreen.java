package subway.screen;

import subway.domain.SectionRepository;
import subway.Menu.Menu;
import subway.view.InputView;

import java.util.Scanner;

public class FeatureScreen implements ScreenModel {

    private final Scanner scanner;
    private final String input;

    public FeatureScreen(Scanner scanner, String input) {
        this.scanner = scanner;
        this.input = input;
    }

    @Override
    public String showScreen() {
        InputView inputView = new InputView(scanner);

        if (input.equals(Menu.ROUTE_CRITERIA.SHORTEST_PATH.getCode())) {
            // 최단경로 by 거리 수행
            System.out.println("[임시] 최단경로 by 거리 수행합니다.");
            SectionRepository.findShortestPathByDistance("교대역", "양재역");
        }

        if (input.equals(Menu.ROUTE_CRITERIA.SHORTEST_TIME.getCode())) {
            // 최단경로 by 시간 수행
            System.out.println("[임시] 최단경로 by 거리 수행합니다.");
        }

        return GO_MAIN;
    }

    @Override
    public ScreenModel getNextScreen(String input) {
        return new MainScreen(scanner);
    }
}
