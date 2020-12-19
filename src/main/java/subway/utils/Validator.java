package subway.utils;

import subway.Constant;
import subway.menu.MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {

    public static void checkMainInputOrder(String order) {
        List<String> orderList = Stream.of(MainMenu.values())
                .map(m -> m.getOrder())
                .collect(Collectors.toList());

        for(String str : orderList) {
            if(str.equalsIgnoreCase(order)){
                return;
            }
        }

        throw new IllegalArgumentException(Constant.ILLEGAL_ARGUMENT_EXCEPTION_INVALID_ORDER);
    }
}
