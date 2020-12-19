package subway.domain;

import subway.exception.DistanceAlreadyExistException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistanceRepository {
    private static Map<Station, List<Distance>> distanceMap = new HashMap<>();

    public static void addDistance(Distance distanceToAdd){
        List<Distance> distanceList1 = distanceMap.getOrDefault(distanceToAdd.getStation1(), new ArrayList<>());
        List<Distance> distanceList2 = distanceMap.getOrDefault(distanceToAdd.getStation1(), new ArrayList<>());
        if(distanceList1.contains(distanceToAdd)){
            throw new DistanceAlreadyExistException();
        }
        distanceList1.add(distanceToAdd);
        distanceList2.add(distanceToAdd);
        distanceMap.put(distanceToAdd.getStation1(), distanceList1);
        distanceMap.put(distanceToAdd.getStation2(), distanceList2);
    }

    public static int getPhysicalDistance(List<Station> stations){
        int total = 0;
        for(int i = 0; i < stations.size() - 1; i++) {
            final int idx = i;
            List<Distance> stationList = distanceMap.get(stations.get(idx));
            List<Distance> currentDistance = stationList.stream()
                    .filter(distance -> distance.getStation1().equals(stations.get(idx + 1)) ||
                            distance.getStation2().equals(stations.get(idx + 1)))
                    .collect(Collectors.toList());
            total += currentDistance.get(0).getPhysicalDistance();
        }
        return total;
    }

    public static int getTimeDistance(List<Station> stations){
        int total = 0;
        for(int i = 0; i < stations.size() - 1; i++) {
            final int idx = i;
            List<Distance> stationList = distanceMap.get(stations.get(idx));
            List<Distance> currentDistance = stationList.stream()
                    .filter(distance -> distance.getStation1().equals(stations.get(idx + 1)) ||
                            distance.getStation2().equals(stations.get(idx + 1)))
                    .collect(Collectors.toList());
            total += currentDistance.get(0).getTimeDistance();
        }
        return total;
    }
}
