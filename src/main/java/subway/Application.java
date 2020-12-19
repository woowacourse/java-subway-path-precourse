package subway;

import java.util.Scanner;
import subway.controller.MainDashboard;
import subway.controller.RouteCalculator;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        new InitialMap();
        MainDashboard mainDashboard = new MainDashboard(inputView);
    }
}
