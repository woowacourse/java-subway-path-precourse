package subway.domain;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

public class ErrorMessage {

    private static final String PREFIX = "[ERROR] ";
    private static final String CANNOT_CHOOSE_FUNCTION = "선택할 수 없는 기능입니다";
    private static final String NOT_EXIST_STATION = "존재하지 않는 역입니다";

    public static String isNotFunction() {
        return PREFIX + CANNOT_CHOOSE_FUNCTION;
    }

    public static String isNotStation() {
        return PREFIX + NOT_EXIST_STATION;
    }


}
