package subway;

import subway.setUp.SetUp;

public class Application {
    public static void main(String[] args) {
        SetUp.setUp();
        SubwayApplication subwayApplication = new SubwayApplication();
        subwayApplication.run();
    }
}
