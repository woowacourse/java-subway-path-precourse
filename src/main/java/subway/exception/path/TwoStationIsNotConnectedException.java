package subway.exception.path;

import subway.util.PrintUtils;

public class TwoStationIsNotConnectedException extends PathException {

    @Override
    public void printError() {
        PrintUtils.printError("출발역과 도착역이 연결되어 있지 않습니다.");
    }

}
