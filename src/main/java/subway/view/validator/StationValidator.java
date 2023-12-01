package subway.view.validator;

import subway.util.constants.StationName;

import static subway.util.message.ExceptionMessage.INPUT_MESSAGE;

public class StationValidator extends Validator{
    public static void validate(final String str){
        validateBlank(str);
        validateStationName(str);
    }

    private static void validateStationName(final String input) {
        if(!input.endsWith(StationName.STATION_SUFFIX.getKey())){
            throw new IllegalArgumentException(String.format(INPUT_MESSAGE.getValue(), "역 이름을 올바르게 입력해주세요."));
        };
    }
}
