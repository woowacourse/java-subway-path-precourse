package subway;

import subway.domain.StationManager;

public class Application {
    public static void main(String[] args) {
        InitDataList.insertData();
        StationManager.start();
    }
}
