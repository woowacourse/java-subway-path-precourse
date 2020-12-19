package subway.view;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputString() {
        return scanner.nextLine();
    }

    public static Station getDepartureStation() {
        OutputView.printNotice("출발역을 입력하세요.");
        return StationRepository.findByName(getInputString());
    }

    public static Station getArrivalStation() {
        OutputView.printNotice("도착역을 입력하세요.");
        return StationRepository.findByName(getInputString());
    }
}
