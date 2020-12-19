package subway.utils;

import subway.domain.StationRepository;

public class ValidateUtils {
    public static boolean isValidMenuSelect(String selectMenu, int bound, char quit) {
        if (selectMenu.length() > 1) {
            return false;
        }
        char selectChar = selectMenu.charAt(0);
        if (selectChar == quit || (selectChar >= '1' && selectChar <= bound + '0')) {
            return true;
        }
        return false;
    }

    public static boolean isValidStationName(String stationName) {
        if (stationName.length() < 2) {
            return false;
        }
        if (!StationRepository.contains(stationName)){
            return false;
        }
        return true;
    }
}
