package subway.exception.path;

import subway.util.PrintUtils;

public class SameFromToStationException extends PathException {

    @Override
    public void printError() {
        PrintUtils.printError("출발역과 도착역이 동일합니다.");
    }
}
