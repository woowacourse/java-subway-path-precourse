package subway.view.validator;

import subway.util.constants.StationName;

import static subway.util.message.ExceptionMessage.INPUT_MESSAGE;

public class StationValidator extends Validator{

    private static final String STATION_SUFFIX = "역";
    public static void validate(final String str){
        validateBlank(str);
        validateStationName(str);
    }

    private static void validateStationName(final String input) {
        if(!input.endsWith(STATION_SUFFIX)){
            throw new IllegalArgumentException(String.format(INPUT_MESSAGE.getValue(), "역 이름을 올바르게 입력해주세요."));
        };
    }
}
