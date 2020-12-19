package subway.view.validation;

import java.util.List;

public class NotExistOption {
    private static final String NOT_EXIST_OPTION = "[ERROR] 존재하지 않는 옵션입니다.";

    public static void validate(String option, List<String> optionList) {
        if (!optionList.contains(option)) {
            throw new IllegalArgumentException(NOT_EXIST_OPTION);
        }
    }
}
