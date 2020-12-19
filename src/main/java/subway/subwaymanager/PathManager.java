package subway.subwaymanager;

import subway.domain.DistanceGraph;
import subway.domain.Path;
import subway.domain.PathRepository;
import subway.utils.InputView;
import subway.utils.OutputView;
import subway.utils.ValidateStationSameNameCheck;

import java.util.ArrayList;
import java.util.List;

import static subway.utils.Constant.*;
import static subway.utils.Constant.CONTENTS_NUMBER_BACK;

public class PathManager {

    public static void pathChoice() {
        boolean isContinue = true;
        while (isContinue) {
            OutputView.printPathContents();
            String inputPathSelect = InputView.inputSelect();
            isContinue = selectPath(inputPathSelect);
        }
    }

    private static boolean selectPath(String inputPathSelect) {
        if (inputPathSelect.equals(CONTENTS_NUMBER_FIRST)) {
            shortestDistanceSearch();
        }
        if (inputPathSelect.equals(CONTENTS_NUMBER_SECOND)) {
        }
        if (inputPathSelect.equals(CONTENTS_NUMBER_BACK)) {
            return false;
        }
        return true;
    }

    private static void shortestDistanceSearch() {
        System.out.println("시작역 ");
        String start = InputView.inputStationName();
        System.out.println("끝역");
        String end = InputView.inputStationName();
        ValidateStationSameNameCheck.validateStationSameNameCheck(start, end);
        List<String> stationNames = DistanceGraph.getPath(start, end);
        List<Path> paths = new ArrayList<>();
        for (int i = 1; i < stationNames.size(); i++) {
            paths.add(PathRepository.getPath(stationNames.get(i -1), stationNames.get(i)));
        }
        OutputView.printResult(stationNames, paths);
        System.out.println();
    }
}
