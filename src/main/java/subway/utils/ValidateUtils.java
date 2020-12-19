package subway.utils;

import subway.exception.SubwayException;

public class ValidateUtils {

    public static String isNotEmpty(String input) {
        if (input.trim().length() > 0){
            return input;
        }
        throw new SubwayException("빈 값입니다.");
    }

    public static void isSame(String input, String anotherInput){
        if(input.equals(anotherInput)){
            throw new SubwayException("출발역과 도착역이 동일합니다.");
        }
    }
}
