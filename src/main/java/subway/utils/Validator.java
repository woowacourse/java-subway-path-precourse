package subway.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static boolean isValidMainInput(String inputMsg) {
        List<String> validMsgList = new ArrayList<>(Arrays.asList("1", "Q"));
        return validMsgList.contains(inputMsg);
    }

    public static boolean isValidPathInput(String inputMsg) {
        List<String> validMsgList = new ArrayList<>(Arrays.asList("1", "2", "B"));
        return validMsgList.contains(inputMsg);
    }
}
