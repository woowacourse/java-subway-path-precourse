package subway.utils;

import java.util.HashMap;
import java.util.Map;
import subway.domain.Station;

public class Result {
   public static Map<Station, Integer> distances = new HashMap<>();
   public static Map<Station, Station> preNode = new HashMap<>();
}
