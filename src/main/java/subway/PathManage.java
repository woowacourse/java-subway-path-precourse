package subway;

import subway.domain.Constants;
import subway.domain.Errors;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.View;

import java.util.Scanner;

import static subway.Application.startProgram;

public class PathManage {
    public static void managePath(Scanner kbd) {
        View.showPathMenu();
        String input = InputView.inputFunction(kbd, Constants.SUB_FUNCTIONS);
        if (input.equals(Constants.MIN_DISTANCE))
            findMinDistance(kbd);
        if (input.equals(Constants.MIN_TIME))
            findMinTime(kbd);
        if (input.equals(Constants.GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void findMinDistance(Scanner kbd) {
        try {
            InputView.inputSrcDest(kbd);
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void findMinTime(Scanner kbd) {
        try {
            InputView.inputSrcDest(kbd);
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }
}
