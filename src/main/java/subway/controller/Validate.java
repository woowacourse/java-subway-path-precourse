package subway.controller;

import subway.Exception.CustomException;

public class Validate {
    public static void matchWithRegex(String regex, String userInput) {
        if (!userInput.matches(regex)) {
            throw new CustomException("존재하지 않는 메뉴입니다.");
        }
    }

}