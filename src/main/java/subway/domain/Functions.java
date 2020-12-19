package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Functions extends Menus {

    private static final String searchSign = "1";
    private static final String quitSign = "Q";
    private static List<String> signs = Arrays
        .asList(new String[]{searchSign, quitSign});

    public Functions() {
    }

    @Override
    public List<String> getSigns() {
        return signs;
    }
}
