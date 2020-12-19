package subway.view;

import static subway.SubwayKeyWords.*;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }


    public String chooseOption() {
        System.out.println(MESSAGE_CHOOSE_OPTION);
        return scanner.nextLine();
    }

    public String ChooseDepartureStation() {
        System.out.println(MESSAGE_CHOOSE_DEPARTURE_STATION);
        return scanner.nextLine();
    }

    public String ChooseArrivalStation() {
        System.out.println(MESSAGE_CHOOSE_ARRIVAL_STATION);
        return scanner.nextLine();
    }

}
