package subway.view;

import java.util.List;

import subway.view.constants.ViewConstant;

public class PathOutputView {
    public static final String CHECK_RESULT = "조회 결과";
    public static final String DISTANCE = "총 거리: %dkm";
    public static final String TIME = "총 소요 시간: %d분";

    public static void showCheckedResult(List<String> pathStations, int distance, int time) {
        System.out.println(CHECK_RESULT);
        System.out.printf(ViewConstant.INFO, ViewConstant.DASH);
        showConsumedDistanceTime(distance, time);
        System.out.printf(ViewConstant.INFO, ViewConstant.DASH);
        showPathStations(pathStations);
    }

    private static void showConsumedDistanceTime(int distance, int time) {
        String distanceFormat = String.format(DISTANCE, distance);
        String timeFormat = String.format(TIME, time);
        System.out.printf(ViewConstant.INFO, distanceFormat);
        System.out.printf(ViewConstant.INFO, timeFormat);
    }

    private static void showPathStations(List<String> pathStations) {
        for (String station : pathStations) {
            System.out.printf(ViewConstant.INFO, station);
        }
    }
}
