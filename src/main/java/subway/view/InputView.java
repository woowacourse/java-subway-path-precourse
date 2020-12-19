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

    public static void inputSrcDest(Scanner kbd) {
        try {
            System.out.println("\n## 출발역을 입력하세요.");
            String srcStation = kbd.nextLine();
            Errors.checkExistStation(srcStation);
            System.out.println("\n## 도착역을 입력하세요.");
            String destStation = kbd.nextLine();
            Errors.checkExistStation(destStation);
            Errors.checkSameName(srcStation, destStation);
        } catch (Exception e) {
            inputSrcDest(kbd);
        }
    }
}
