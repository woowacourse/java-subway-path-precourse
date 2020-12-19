package subway.service;

import subway.domain.SubwayPath;
import subway.repository.SubwayPathRepository;

public class SubwayPathService {
    public static void addPath(String departureStation, String arrivalStation, int distance, int time) {
        SubwayPath subwayPath = new SubwayPath(departureStation, arrivalStation, distance, time);
        SubwayPathRepository.addPath(subwayPath);
    }
}
