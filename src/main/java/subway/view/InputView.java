package subway.view;

import subway.domain.Errors;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static String inputFunction(Scanner kbd, List<String> functions) {
        String input = "0";
        try {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            input = kbd.nextLine();
            Errors.checkInput(input, functions);
        } catch (Exception e) {
            inputFunction(kbd, functions);
        }
        return input;
    }

    public static String[] inputSrcDest(Scanner kbd) {
        String[] stations = new String[2];
        try {
            System.out.println("\n## 출발역을 입력하세요.");
            stations[0] = kbd.nextLine();
            Errors.checkExistStation(stations[0]);
            System.out.println("\n## 도착역을 입력하세요.");
            stations[1] = kbd.nextLine();
            Errors.checkExistStation(stations[1]);
            Errors.checkSameName(stations[0], stations[1]);
        } catch (Exception e) {
            inputSrcDest(kbd);
        }
        return stations;
    }
}
