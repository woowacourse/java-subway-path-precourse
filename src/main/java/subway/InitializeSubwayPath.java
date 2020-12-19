package subway;

import subway.domain.DistanceRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.DistanceService;

public class InitializeSubwayPath {
    public static void initialize() {
        Station stationKyoDae = new Station("교대역");
        Station stationGangNam = new Station("강남역");
        Station stationYeokSam = new Station("역삼역");
        Station stationNambuStation = new Station("남부터미널역");
        Station stationYangJe = new Station("양재역");
        Station stationYangJeForest = new Station("양재시민의숲역");
        Station stationMeBong = new Station("매봉역");
        StationRepository.addStation(stationKyoDae);
        StationRepository.addStation(stationGangNam);
        StationRepository.addStation(stationYeokSam);
        StationRepository.addStation(stationNambuStation);
        StationRepository.addStation(stationYangJe);
        StationRepository.addStation(stationYangJeForest);
        StationRepository.addStation(stationMeBong);

        DistanceService.addDistance(stationKyoDae, stationGangNam, 2, 3);
        DistanceService.addDistance(stationGangNam, stationYeokSam, 2, 3);
        DistanceService.addDistance(stationKyoDae, stationNambuStation, 2, 3);
        DistanceService.addDistance(stationNambuStation, stationYangJe, 2, 3);
        DistanceService.addDistance(stationYangJe, stationMeBong, 2, 3);
        DistanceService.addDistance(stationGangNam, stationYangJe, 2, 3);
        DistanceService.addDistance(stationYangJe, stationYangJeForest, 2, 3);
    }
}
