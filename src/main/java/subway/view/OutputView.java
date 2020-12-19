package subway.view;

import java.util.Arrays;
import subway.model.ResultDto;
import subway.view.mainview.MainChoice;
import subway.view.pathview.PathChoice;

public class OutputView {

    public static final String RESULT_PREFIX  = "[INFO] ";
    public static final String LINE_DIVIDE_STRNG = "---";

    public static void printMainMenuInputGuideMessage() {
        Arrays.asList(MainChoice.values())
            .stream()
            .forEach(s -> System.out.println(s.toString()));
    }

    public static void printPathMenuInputGuideMessage() {
        Arrays.asList(PathChoice.values())
            .stream()
            .forEach(s -> System.out.println(s.toString()));
    }

    public static void printInputStartStationGuideMessage() {
        println(View.VIEW_PREFIX + "출발역을 입력하세요.");
    }

    public static void printInputEndStationGuideMessage() {
        println(View.VIEW_PREFIX + "도착역을 입력하세요.");
    }

    public static void printResult(ResultDto result) {
        println(View.VIEW_PREFIX + "조회 결과");
        println(RESULT_PREFIX + LINE_DIVIDE_STRNG);
        println(RESULT_PREFIX + "총 거리: " + result.getTotalDistance() + "km");
        println(RESULT_PREFIX + "총 소요 시간: " + result.getTotalTime() + "분");
        println(RESULT_PREFIX + LINE_DIVIDE_STRNG);
        result.getPath()
            .stream()
            .map(station -> station.getName())
            .forEach((station) -> {
                System.out.println(RESULT_PREFIX + station);
            });
        System.out.println();
    }

    public static void println() {
        println();
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

}
