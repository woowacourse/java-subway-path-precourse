package subway.domain;

import subway.controller.MenuController;

import java.util.Arrays;
import java.util.List;

public class Criterions extends MenuController {

    private static final String distanceSign = "1";
    private static final String timeSign = "2";
    private static final String backSign = "B";
    private static final List<String> signs = Arrays
        .asList(new String[]{distanceSign, timeSign, backSign});

    public Criterions() {
    }
}
