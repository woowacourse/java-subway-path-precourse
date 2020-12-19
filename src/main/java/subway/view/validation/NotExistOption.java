package subway.view.validation;

import subway.MainOption;

import java.util.ArrayList;
import java.util.List;

public class NotExistOption {
    private static final String NOT_EXIST_OPTION = "[ERROR] 존재하지 않는 옵션입니다.";

    public static void validate(String option, List<MainOption> optionList) {
        List<String> options = new ArrayList<>();

        for (MainOption mainOption : optionList) {
            options.add(mainOption.getValue());
        }

        if (!options.contains(option)) {
            throw new IllegalArgumentException(NOT_EXIST_OPTION);
        }
    }
}
