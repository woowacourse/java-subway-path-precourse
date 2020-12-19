package subway.output;

import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/19
 */
public class OutputView {
    public static final String EQUALS_STATION_ERROR = "[ERROR] 출발역과 도착역이 동일합니다.";

    public static void printPage(List<String> mainPageItem) {
        for (String item : mainPageItem) {
            System.out.println(item);
        }
    }

    public static void printStartStationEqualsFinishStationError() {
        System.out.println(EQUALS_STATION_ERROR);
    }
}
