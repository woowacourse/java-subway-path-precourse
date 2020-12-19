package subway.controller;

import subway.Exception.CustomException;
import subway.domain.StationRepository;

public class Validate {
    public static void matchWithRegex(String regex, String userInput) {
        if (!userInput.matches(regex)) {
            throw new CustomException("존재하지 않는 메뉴입니다.");
        }
    }

    public static void existStation(String name) {
        if (!StationRepository.existStation(name)) {
            throw new CustomException("존재하지 않는 역입니다.");
        }
    }

    public static void notSameStation(String startStation, String endStation) {
        if (startStation.equals(endStation)) {
            throw new CustomException("출발역과 도착역이 동일합니다.");
        }
    }
}